package com.example.querydsl.service.shop.entity.review;

import com.example.querydsl.service.shop.entity.customer.Customer;
import com.example.querydsl.service.shop.entity.shop.Shop;
import com.example.querydsl.service.shop.input.review.ShopReviewInput;
import com.example.querydsl.util.RandomUtil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class ShopReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shop_review_id")
    private Long id;

    @Lob
    private String content;

    private long grade; // 1 ~ 5

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shop_id")
    private Shop shop;

    @CreatedDate
    private LocalDateTime registerTime;

    @LastModifiedDate
    private LocalDateTime updateTime;

    public static ShopReview from(long id, String content, long grade, long customerId, long shopId, long sellerId) {
        return ShopReview.builder()
                .id(id)
                .content(content)
                .grade(grade)
                .registerTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .customer(Customer.from(
                        customerId
                        , RandomUtil.createRandomName()
                        , RandomUtil.createRandomPhoneNumber()
                        , RandomUtil.createRandomAddress()
                        , RandomUtil.createRandomBirthDate()
                        , RandomUtil.createRandomMoney()))
                .shop(Shop.from(
                        shopId
                        , RandomUtil.createRandomName()
                        , RandomUtil.createRandomMoney()
                        , RandomUtil.createRandomString(1000)
                        , sellerId
                ))
                .build();
    }

    public static ShopReview from(ShopReviewInput shopReviewInput) {
        return ShopReview.builder()
                .id(shopReviewInput.getId())
                .content(shopReviewInput.getContent())
                .grade(shopReviewInput.getGrade())
                .registerTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .customer(Customer.from(shopReviewInput.getCustomerId()
                        , RandomUtil.createRandomName()
                        , RandomUtil.createRandomPhoneNumber()
                        , RandomUtil.createRandomAddress()
                        , RandomUtil.createRandomBirthDate()
                        , RandomUtil.createRandomMoney()))
                .build();
    }
}
