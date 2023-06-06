package com.example.querydsl.service.shop.repository.review.sql;

public class ShopReviewSql {
    public static final String SHOP_REVIEW_INSERT_QUERY = "INSERT INTO SHOP_REVIEW " +
            "(`shop_review_id`, `content`, `grade`, `customer_id`, `shop_id`, `register_time`, `update_time`) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?)";
}
