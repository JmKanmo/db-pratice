package com.example.querydsl.service.shop.entity.shop;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QShop is a Querydsl query type for Shop
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QShop extends EntityPathBase<Shop> {

    private static final long serialVersionUID = 1898260762L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QShop shop = new QShop("shop");

    public final StringPath description = createString("description");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final NumberPath<Long> price = createNumber("price", Long.class);

    public final ListPath<com.example.querydsl.service.shop.entity.product.Product, com.example.querydsl.service.shop.entity.product.QProduct> productList = this.<com.example.querydsl.service.shop.entity.product.Product, com.example.querydsl.service.shop.entity.product.QProduct>createList("productList", com.example.querydsl.service.shop.entity.product.Product.class, com.example.querydsl.service.shop.entity.product.QProduct.class, PathInits.DIRECT2);

    public final DateTimePath<java.time.LocalDateTime> registerTime = createDateTime("registerTime", java.time.LocalDateTime.class);

    public final com.example.querydsl.service.shop.entity.seller.QSeller seller;

    public final ListPath<com.example.querydsl.service.shop.entity.review.ShopReview, com.example.querydsl.service.shop.entity.review.QShopReview> shopReviewList = this.<com.example.querydsl.service.shop.entity.review.ShopReview, com.example.querydsl.service.shop.entity.review.QShopReview>createList("shopReviewList", com.example.querydsl.service.shop.entity.review.ShopReview.class, com.example.querydsl.service.shop.entity.review.QShopReview.class, PathInits.DIRECT2);

    public final DateTimePath<java.time.LocalDateTime> updateTime = createDateTime("updateTime", java.time.LocalDateTime.class);

    public QShop(String variable) {
        this(Shop.class, forVariable(variable), INITS);
    }

    public QShop(Path<? extends Shop> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QShop(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QShop(PathMetadata metadata, PathInits inits) {
        this(Shop.class, metadata, inits);
    }

    public QShop(Class<? extends Shop> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.seller = inits.isInitialized("seller") ? new com.example.querydsl.service.shop.entity.seller.QSeller(forProperty("seller")) : null;
    }

}

