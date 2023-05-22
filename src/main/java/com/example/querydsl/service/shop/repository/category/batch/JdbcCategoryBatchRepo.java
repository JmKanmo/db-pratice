package com.example.querydsl.service.shop.repository.category.batch;


import com.example.querydsl.service.shop.entity.category.Category;
import com.example.querydsl.service.shop.repository.category.sql.CategorySql;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class JdbcCategoryBatchRepo {
    private final JdbcTemplate jdbcTemplate;

    @Transactional
    public void saveAllCustomer(List<Category> items, int batchSize) {
        int batchCount = 0;
        List<Category> subItems = new ArrayList<>();
        for (int i = 0; i < items.size(); i++) {
            subItems.add(items.get(i));
            if ((i + 1) % batchSize == 0) {
                batchCount = batchCategoryInsert(batchSize, batchCount, subItems);
            }
        }
        if (!subItems.isEmpty()) {
            batchCount = batchCategoryInsert(batchSize, batchCount, subItems);
        }
        System.out.println("batchCount: " + batchCount);
    }

    private int batchCategoryInsert(int batchSize, int batchCount, List<Category> subItems) {
        jdbcTemplate.batchUpdate(CategorySql.CATEGORY_INSERT_QUERY,
                new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        ps.setLong(1, subItems.get(i).getId());
                        ps.setString(2, subItems.get(i).getName());
                        ps.setTimestamp(3, Timestamp.valueOf(subItems.get(i).getRegisterTime()));
                        ps.setTimestamp(4, Timestamp.valueOf(subItems.get(i).getUpdatedTime()));
                    }

                    @Override
                    public int getBatchSize() {
                        return subItems.size();
                    }
                });
        subItems.clear();
        batchCount++;
        return batchCount;
    }
}