package com.example.querydsl.service.shop.repository.shop.jpa;

import com.example.querydsl.service.shop.entity.shop.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository extends JpaRepository<Shop, Long> {
}
