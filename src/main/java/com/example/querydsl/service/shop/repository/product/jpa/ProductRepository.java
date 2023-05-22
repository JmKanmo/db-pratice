package com.example.querydsl.service.shop.repository.product.jpa;

import com.example.querydsl.service.shop.entity.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
