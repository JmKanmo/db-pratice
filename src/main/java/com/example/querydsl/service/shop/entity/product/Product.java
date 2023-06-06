package com.example.querydsl.service.shop.entity.product;

import com.example.querydsl.service.shop.entity.review.ProductReview;
import com.example.querydsl.service.shop.entity.shop.Shop;
import com.example.querydsl.service.shop.entity.category.Category;
import com.example.querydsl.service.shop.input.product.ProductInput;
import com.example.querydsl.util.RandomUtil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    private String name;

    private long price;

    private long count;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shop_id")
    private Shop shop;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @Fetch(FetchMode.SUBSELECT)
    @OneToMany(mappedBy = "product")
    private List<ProductReview> productReviewList;

    @CreatedDate
    private LocalDateTime registerTime;

    @LastModifiedDate
    private LocalDateTime updateTime;

    public static Product from(long id, String name, long price, long count, long categoryId, long shopId) {
        return Product.builder()
                .id(id)
                .name(name)
                .price(price)
                .count(count)
                .registerTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .category(Category.from(
                        categoryId
                        , RandomUtil.createRandomCategoryName()))
                .shop(Shop.from(
                        shopId,
                        RandomUtil.createRandomNickName()
                        , RandomUtil.createRandomMoney()
                        , RandomUtil.createRandomString(10)
                        , 0L))
                .build();
    }

    public static Product from(ProductInput productInput) {
        return Product.builder()
                .id(productInput.getId())
                .name(productInput.getName())
                .price(productInput.getPrice())
                .count(productInput.getCount())
                .shop(Shop.from(
                        productInput.getShopId()
                        , RandomUtil.createRandomNickName()
                        , RandomUtil.createRandomMoney()
                        , RandomUtil.createRandomString(1000)
                        , productInput.getSellerId()))
                .build();
    }
}
