package com.example.querydsl.service.shop.repository.seller.batch;

import com.example.querydsl.service.shop.entity.customer.Customer;
import com.example.querydsl.service.shop.entity.seller.Seller;
import com.example.querydsl.service.shop.repository.customer.sql.CustomerSql;
import com.example.querydsl.service.shop.repository.seller.sql.SellerSql;
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
public class JdbcSellerBatchRepo {
    private final JdbcTemplate jdbcTemplate;

    @Transactional
    public void saveAllCustomer(List<Seller> items, int batchSize) {
        int batchCount = 0;
        List<Seller> subItems = new ArrayList<>();

        for (int i = 0; i < items.size(); i++) {
            subItems.add(items.get(i));
            if ((i + 1) % batchSize == 0) {
                batchCount = batchCustomerInsert(batchSize, batchCount, subItems);
            }
        }
        if (!subItems.isEmpty()) {
            batchCount = batchCustomerInsert(batchSize, batchCount, subItems);
        }
        System.out.println("batchCount: " + batchCount);
    }

    private int batchCustomerInsert(int batchSize, int batchCount, List<Seller> subItems) {
        jdbcTemplate.batchUpdate(SellerSql.SELLER_INSERT_QUERY,
                new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        ps.setLong(1, subItems.get(i).getId());
                        ps.setString(2, subItems.get(i).getAddress());
                        ps.setString(3, subItems.get(i).getName());
                        ps.setTimestamp(4, Timestamp.valueOf(subItems.get(i).getRegisterTime()));
                        ps.setTimestamp(5, Timestamp.valueOf(subItems.get(i).getUpdateTime()));
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
