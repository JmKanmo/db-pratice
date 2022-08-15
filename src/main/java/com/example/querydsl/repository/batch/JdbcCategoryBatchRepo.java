package com.example.querydsl.repository.batch;


import com.example.querydsl.entity.Category;
import com.example.querydsl.entity.Customer;
import com.example.querydsl.util.QueryUtil;
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
        jdbcTemplate.batchUpdate(QueryUtil.CATEGORY_INSERT_QUERY,
                new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        ps.setLong(1, subItems.get(i).getId());
                        ps.setString(2, subItems.get(i).getName());
                        ps.setTimestamp(3, Timestamp.valueOf(subItems.get(i).getCreatedDate()));
                        ps.setTimestamp(4, Timestamp.valueOf(subItems.get(i).getModifiedDate()));
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