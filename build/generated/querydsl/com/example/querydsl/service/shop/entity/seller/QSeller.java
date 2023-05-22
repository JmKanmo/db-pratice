package com.example.querydsl.service.shop.entity.seller;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSeller is a Querydsl query type for Seller
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSeller extends EntityPathBase<Seller> {

    private static final long serialVersionUID = 898441466L;

    public static final QSeller seller = new QSeller("seller");

    public final StringPath address = createString("address");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final DateTimePath<java.time.LocalDateTime> registerTime = createDateTime("registerTime", java.time.LocalDateTime.class);

    public final ListPath<com.example.querydsl.service.shop.entity.shop.Shop, com.example.querydsl.service.shop.entity.shop.QShop> shopList = this.<com.example.querydsl.service.shop.entity.shop.Shop, com.example.querydsl.service.shop.entity.shop.QShop>createList("shopList", com.example.querydsl.service.shop.entity.shop.Shop.class, com.example.querydsl.service.shop.entity.shop.QShop.class, PathInits.DIRECT2);

    public final DateTimePath<java.time.LocalDateTime> updateTime = createDateTime("updateTime", java.time.LocalDateTime.class);

    public QSeller(String variable) {
        super(Seller.class, forVariable(variable));
    }

    public QSeller(Path<? extends Seller> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSeller(PathMetadata metadata) {
        super(Seller.class, metadata);
    }

}

