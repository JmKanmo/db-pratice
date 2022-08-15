package com.example.querydsl.util;

public class QueryUtil {
    public static final String CATEGORY_INSERT_QUERY = "INSERT INTO CATEGORY(`category_id`,`name`,`created_date`,`modified_date`) VALUE(?,?,?,?)";
    public static final String CUSTOMER_INSERT_QUERY = "INSERT INTO CUSTOMER (`ID`, `NAME`) VALUES (?, ?)";
}
