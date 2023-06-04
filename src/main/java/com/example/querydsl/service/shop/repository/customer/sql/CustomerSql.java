package com.example.querydsl.service.shop.repository.customer.sql;

public class CustomerSql {
    public static final String CUSTOMER_INSERT_QUERY = "INSERT INTO CUSTOMER " +
            "(`customer_id`, `address`, `birth`, `money`, `name`, `phone`, `register_time`, `update_time`) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
}
