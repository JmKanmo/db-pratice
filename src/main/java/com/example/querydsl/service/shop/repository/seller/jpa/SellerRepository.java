package com.example.querydsl.service.shop.repository.seller.jpa;

import com.example.querydsl.service.shop.entity.seller.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller, Long> {
}
