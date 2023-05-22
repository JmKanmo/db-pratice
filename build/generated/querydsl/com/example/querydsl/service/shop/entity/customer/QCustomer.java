package com.example.querydsl.service.shop.entity.customer;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCustomer is a Querydsl query type for Customer
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCustomer extends EntityPathBase<Customer> {

    private static final long serialVersionUID = 1029936666L;

    public static final QCustomer customer = new QCustomer("customer");

    public final StringPath address = createString("address");

    public final StringPath birth = createString("birth");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> money = createNumber("money", Long.class);

    public final StringPath name = createString("name");

    public final StringPath phone = createString("phone");

    public final ListPath<com.example.querydsl.service.shop.entity.review.ProductReview, com.example.querydsl.service.shop.entity.review.QProductReview> productReviewList = this.<com.example.querydsl.service.shop.entity.review.ProductReview, com.example.querydsl.service.shop.entity.review.QProductReview>createList("productReviewList", com.example.querydsl.service.shop.entity.review.ProductReview.class, com.example.querydsl.service.shop.entity.review.QProductReview.class, PathInits.DIRECT2);

    public final DateTimePath<java.time.LocalDateTime> registerTime = createDateTime("registerTime", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> updateTime = createDateTime("updateTime", java.time.LocalDateTime.class);

    public QCustomer(String variable) {
        super(Customer.class, forVariable(variable));
    }

    public QCustomer(Path<? extends Customer> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCustomer(PathMetadata metadata) {
        super(Customer.class, metadata);
    }

}

