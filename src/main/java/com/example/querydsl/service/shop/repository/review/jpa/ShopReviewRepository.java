package com.example.querydsl.service.shop.repository.review.jpa;

import com.example.querydsl.service.shop.entity.review.ShopReview;
import com.example.querydsl.service.shop.entity.shop.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopReviewRepository extends JpaRepository<ShopReview, Long> {
}
