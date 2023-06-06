package com.example.querydsl.service.shop.repository.category.sql;

public class CategorySql {
    public static final String CATEGORY_INSERT_QUERY = "INSERT INTO CATEGORY(`category_id`,`name`,`register_time`,`updated_time`) VALUE(?,?,?,?)";
}
