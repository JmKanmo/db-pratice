package com.example.querydsl.service.shop.repository.seller.sql;

public class SellerSql {
    public static final String SELLER_INSERT_QUERY = "INSERT INTO SELLER (`seller_id`, `address`, `name`, `register_time`, `update_time`) VALUES (?, ?, ?, ?, ?)";
}
