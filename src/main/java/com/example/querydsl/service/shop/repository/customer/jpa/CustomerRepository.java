package com.example.querydsl.service.shop.repository.customer.jpa;

import com.example.querydsl.service.shop.entity.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
