package com.example.querydsl.service.shop.repository.product.batch;

import com.example.querydsl.service.shop.entity.product.Product;
import com.example.querydsl.service.shop.repository.product.sql.ProductSql;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class JdbcProductBatchRepo {
    private final JdbcTemplate jdbcTemplate;

    @Transactional
    public void saveAllProduct(List<Product> items, int batchSize) {
        int batchCount = 0;
        List<Product> subItems = new ArrayList<>();

        for (int i = 0; i < items.size(); i++) {
            subItems.add(items.get(i));
            if ((i + 1) % batchSize == 0) {
                batchCount = batchProductInsert(batchSize, batchCount, subItems);
            }
        }
        if (!subItems.isEmpty()) {
            batchCount = batchProductInsert(batchSize, batchCount, subItems);
        }
        System.out.println("batchCount: " + batchCount);
    }

    private int batchProductInsert(int batchSize, int batchCount, List<Product> subItems) {
        jdbcTemplate.batchUpdate(ProductSql.PRODUCT_INSERT_QUERY,
                new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        ps.setLong(1, subItems.get(i).getId());
                        ps.setLong(2, subItems.get(i).getCount());
                        ps.setString(3, subItems.get(i).getName());
                        ps.setLong(4, subItems.get(i).getPrice());
                        ps.setTimestamp(5, Timestamp.valueOf(subItems.get(i).getRegisterTime()));
                        ps.setTimestamp(6, Timestamp.valueOf(subItems.get(i).getUpdateTime()));
                        ps.setLong(7, subItems.get(i).getCategory().getId());
                        ps.setLong(8, subItems.get(i).getShop().getId());
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
