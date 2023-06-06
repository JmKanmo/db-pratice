package com.example.querydsl.service.shop.repository.review.sql;

public class ProductReviewSql {
    public static final String PRODUCT_REVIEW_INSERT_QUERY = "INSERT INTO PRODUCT_REVIEW " +
            "(`product_review_id`, `content`, `grade`, `customer_id`, `product_id`, `register_time`, `update_time`) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?)";
}
