package com.example.querydsl.service.shop.repository.review.jpa;

import com.example.querydsl.service.shop.entity.review.ProductReview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductReviewRepository extends JpaRepository<ProductReview, Long> {
}
