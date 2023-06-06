package com.example.querydsl.service.shop.entity.review;

import com.example.querydsl.service.shop.entity.customer.Customer;
import com.example.querydsl.service.shop.entity.product.Product;
import com.example.querydsl.service.shop.input.review.ProductReviewInput;
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
public class ProductReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_review_id")
    private Long id;

    private String content;

    private long grade; // 1 ~ 5

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @CreatedDate
    private LocalDateTime registerTime;

    @LastModifiedDate
    private LocalDateTime updateTime;

    public static ProductReview from(long id, String content, long grade, long customerId, long productId, long categoryId, long shopId) {
        return ProductReview.builder()
                .id(id)
                .content(content)
                .grade(grade)
                .customer(Customer.from(
                        customerId,
                        RandomUtil.createRandomName(),
                        RandomUtil.createRandomPhoneNumber(),
                        RandomUtil.createRandomAddress(),
                        RandomUtil.createRandomBirthDate(),
                        RandomUtil.createRandomMoney()))
                .product(Product.from(
                        productId,
                        RandomUtil.createRandomNickName(),
                        RandomUtil.createRandomMoney(),
                        RandomUtil.createRandomCount(),
                        categoryId,
                        shopId))
                .build();
    }

    public static ProductReview from(ProductReviewInput productReviewInput) {
        return ProductReview.builder()
                .id(productReviewInput.getId())
                .content(productReviewInput.getContent())
                .grade(productReviewInput.getGrade())
                .customer(Customer.from(
                        productReviewInput.getCustomerId(),
                        RandomUtil.createRandomName(),
                        RandomUtil.createRandomPhoneNumber(),
                        RandomUtil.createRandomAddress(),
                        RandomUtil.createRandomBirthDate(),
                        RandomUtil.createRandomMoney()
                ))
                .product(Product.from(
                        productReviewInput.getProductId(),
                        RandomUtil.createRandomNickName(),
                        RandomUtil.createRandomMoney(),
                        RandomUtil.createRandomCount(),
                        productReviewInput.getCategoryId(),
                        productReviewInput.getShopId()
                ))
                .build();
    }
}
