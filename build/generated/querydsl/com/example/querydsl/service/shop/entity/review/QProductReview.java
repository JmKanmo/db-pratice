package com.example.querydsl.service.shop.entity.review;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProductReview is a Querydsl query type for ProductReview
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProductReview extends EntityPathBase<ProductReview> {

    private static final long serialVersionUID = 2074875749L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProductReview productReview = new QProductReview("productReview");

    public final StringPath content = createString("content");

    public final com.example.querydsl.service.shop.entity.customer.QCustomer customer;

    public final NumberPath<Long> grade = createNumber("grade", Long.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final com.example.querydsl.service.shop.entity.product.QProduct product;

    public QProductReview(String variable) {
        this(ProductReview.class, forVariable(variable), INITS);
    }

    public QProductReview(Path<? extends ProductReview> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProductReview(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProductReview(PathMetadata metadata, PathInits inits) {
        this(ProductReview.class, metadata, inits);
    }

    public QProductReview(Class<? extends ProductReview> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.customer = inits.isInitialized("customer") ? new com.example.querydsl.service.shop.entity.customer.QCustomer(forProperty("customer")) : null;
        this.product = inits.isInitialized("product") ? new com.example.querydsl.service.shop.entity.product.QProduct(forProperty("product"), inits.get("product")) : null;
    }

}

