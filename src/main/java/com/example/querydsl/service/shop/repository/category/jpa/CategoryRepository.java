package com.example.querydsl.service.shop.repository.category.jpa;

import com.example.querydsl.service.shop.entity.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
