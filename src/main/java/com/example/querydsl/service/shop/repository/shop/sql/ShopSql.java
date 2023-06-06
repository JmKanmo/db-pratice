package com.example.querydsl.service.shop.repository.shop.sql;

public class ShopSql {
    public static final String SHOP_INSERT_QUERY = "INSERT INTO SHOP (`shop_id`, `description`, `name`, `price`, `register_time`, `update_time`, `seller_id`) VALUES (?, ?, ?, ?, ?, ?, ?)";
}
