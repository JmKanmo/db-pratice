package com.example.querydsl.service.shop.repository.customer.batch;

import com.example.querydsl.service.shop.entity.customer.Customer;
import com.example.querydsl.service.shop.repository.customer.sql.CustomerSql;
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
public class JdbcCustomerBatchRepo {
    private final JdbcTemplate jdbcTemplate;

    @Transactional
    public void saveAllCustomer(List<Customer> items, int batchSize) {
        int batchCount = 0;
        List<Customer> subItems = new ArrayList<>();

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

    private int batchCustomerInsert(int batchSize, int batchCount, List<Customer> subItems) {
        jdbcTemplate.batchUpdate(CustomerSql.CUSTOMER_INSERT_QUERY,
                new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        ps.setLong(1, subItems.get(i).getId());
                        ps.setString(2, subItems.get(i).getAddress());
                        ps.setString(3, subItems.get(i).getBirth());
                        ps.setLong(4, subItems.get(i).getMoney());
                        ps.setString(5, subItems.get(i).getName());
                        ps.setString(6, subItems.get(i).getPhone());
                        ps.setTimestamp(7, Timestamp.valueOf(subItems.get(i).getRegisterTime()));
                        ps.setTimestamp(8, Timestamp.valueOf(subItems.get(i).getUpdateTime()));
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