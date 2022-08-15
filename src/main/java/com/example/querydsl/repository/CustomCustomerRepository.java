package com.example.querydsl.repository;

import com.example.querydsl.entity.Customer;
import com.querydsl.core.Tuple;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomCustomerRepository {
    List<Customer> findCustomersFetch(Pageable pageable);

    Tuple findCustomersFetch();
}
