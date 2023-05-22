package com.example.querydsl.service.shop.entity.review;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QShopReview is a Querydsl query type for ShopReview
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QShopReview extends EntityPathBase<ShopReview> {

    private static final long serialVersionUID = -777719696L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QShopReview shopReview = new QShopReview("shopReview");

    public final StringPath content = createString("content");

    public final com.example.querydsl.service.shop.entity.customer.QCustomer customer;

    public final NumberPath<Long> grade = createNumber("grade", Long.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final com.example.querydsl.service.shop.entity.shop.QShop shop;

    public QShopReview(String variable) {
        this(ShopReview.class, forVariable(variable), INITS);
    }

    public QShopReview(Path<? extends ShopReview> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QShopReview(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QShopReview(PathMetadata metadata, PathInits inits) {
        this(ShopReview.class, metadata, inits);
    }

    public QShopReview(Class<? extends ShopReview> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.customer = inits.isInitialized("customer") ? new com.example.querydsl.service.shop.entity.customer.QCustomer(forProperty("customer")) : null;
        this.shop = inits.isInitialized("shop") ? new com.example.querydsl.service.shop.entity.shop.QShop(forProperty("shop"), inits.get("shop")) : null;
    }

}

