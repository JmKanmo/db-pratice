package com.example.querydsl.service.shop.repository.review.batch;

import com.example.querydsl.service.shop.entity.review.ProductReview;
import com.example.querydsl.service.shop.repository.review.sql.ProductReviewSql;
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
public class JdbcProductReviewBatchRepo {
    private final JdbcTemplate jdbcTemplate;

    @Transactional
    public void saveAllProductReview(List<ProductReview> items, int batchSize) {
        int batchCount = 0;
        List<ProductReview> subItems = new ArrayList<>();

        for (int i = 0; i < items.size(); i++) {
            subItems.add(items.get(i));
            if ((i + 1) % batchSize == 0) {
                batchCount = batchProductReviewInsert(batchSize, batchCount, subItems);
            }
        }
        if (!subItems.isEmpty()) {
            batchCount = batchProductReviewInsert(batchSize, batchCount, subItems);
        }
        System.out.println("batchCount: " + batchCount);
    }

    private int batchProductReviewInsert(int batchSize, int batchCount, List<ProductReview> subItems) {
        jdbcTemplate.batchUpdate(ProductReviewSql.PRODUCT_REVIEW_INSERT_QUERY,
                new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        ps.setLong(1, subItems.get(i).getId());
                        ps.setString(2, subItems.get(i).getContent());
                        ps.setLong(3, subItems.get(i).getGrade());
                        ps.setLong(4, subItems.get(i).getCustomer().getId());
                        ps.setLong(5, subItems.get(i).getProduct().getId());
                        ps.setTimestamp(6, Timestamp.valueOf(subItems.get(i).getRegisterTime()));
                        ps.setTimestamp(7, Timestamp.valueOf(subItems.get(i).getUpdateTime()));
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
