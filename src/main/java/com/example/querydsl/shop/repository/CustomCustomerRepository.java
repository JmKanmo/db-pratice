package com.example.querydsl.shop.repository;

import com.example.querydsl.shop.entity.Customer;
import com.querydsl.core.Tuple;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomCustomerRepository {
    List<Customer> findCustomersFetch(Pageable pageable);

    Tuple findCustomersFetch();
}
