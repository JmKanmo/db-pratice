package com.example.querydsl.service.shop.repository.product.sql;

public class ProductSql {
    public static final String PRODUCT_INSERT_QUERY = "INSERT INTO PRODUCT " +
            "(`product_id`, `count`, `name`, `price`, `register_time`, `update_time`, `category_id`, `shop_id`) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
}
