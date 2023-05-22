package com.example.querydsl.service.shop.repository.customer.querydsl;

import com.example.querydsl.service.shop.entity.customer.Customer;
import com.querydsl.core.Tuple;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface QuerydslCustomerRepository {
    List<Customer> findCustomersFetch(Pageable pageable);

    Tuple findCustomersFetch();
}
