package com.example.querydsl.service.shop.entity.product;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProduct is a Querydsl query type for Product
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProduct extends EntityPathBase<Product> {

    private static final long serialVersionUID = 941767644L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProduct product = new QProduct("product");

    public final com.example.querydsl.service.shop.entity.category.QCategory category;

    public final NumberPath<Long> count = createNumber("count", Long.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final NumberPath<Long> price = createNumber("price", Long.class);

    public final ListPath<com.example.querydsl.service.shop.entity.review.ProductReview, com.example.querydsl.service.shop.entity.review.QProductReview> productReviewList = this.<com.example.querydsl.service.shop.entity.review.ProductReview, com.example.querydsl.service.shop.entity.review.QProductReview>createList("productReviewList", com.example.querydsl.service.shop.entity.review.ProductReview.class, com.example.querydsl.service.shop.entity.review.QProductReview.class, PathInits.DIRECT2);

    public final DateTimePath<java.time.LocalDateTime> registerTime = createDateTime("registerTime", java.time.LocalDateTime.class);

    public final com.example.querydsl.service.shop.entity.shop.QShop shop;

    public final DateTimePath<java.time.LocalDateTime> updateTime = createDateTime("updateTime", java.time.LocalDateTime.class);

    public QProduct(String variable) {
        this(Product.class, forVariable(variable), INITS);
    }

    public QProduct(Path<? extends Product> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProduct(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProduct(PathMetadata metadata, PathInits inits) {
        this(Product.class, metadata, inits);
    }

    public QProduct(Class<? extends Product> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.category = inits.isInitialized("category") ? new com.example.querydsl.service.shop.entity.category.QCategory(forProperty("category")) : null;
        this.shop = inits.isInitialized("shop") ? new com.example.querydsl.service.shop.entity.shop.QShop(forProperty("shop"), inits.get("shop")) : null;
    }

}

