package com.example.querydsl.service.shop.entity.review;

import com.example.querydsl.service.shop.entity.customer.Customer;
import com.example.querydsl.service.shop.entity.product.Product;
import com.example.querydsl.util.BaseUtil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

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

    public static ProductReview from(long id, String content, long grade, long customerId, long productId) {
        return ProductReview.builder()
                .id(id)
                .content(content)
                .grade(grade)
                .customer(Customer.from(customerId, BaseUtil.createRandomName(), BaseUtil.createRandomPhoneNumber(), BaseUtil.createRandomAddress(), BaseUtil.createRandomBirthDate(), 0L))
                .product(Product.from(productId, BaseUtil.createRandomName(), 0L, 0L, 0L, 0L))
                .build();
    }
}
