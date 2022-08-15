package com.example.querydsl.repository;

import com.example.querydsl.entity.Customer;
import com.example.querydsl.entity.QCategory;
import com.example.querydsl.entity.QCustomer;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CustomCustomerRepositoryImpl implements CustomCustomerRepository {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Customer> findCustomersFetch(Pageable pageable) {
        return jpaQueryFactory.selectFrom(QCustomer.customer).offset(pageable.getOffset()).limit(pageable.getPageSize()).fetch();
    }

    @Override
    public Tuple findCustomersFetch() {
        QCustomer customer = QCustomer.customer;
        return jpaQueryFactory.select(customer.count(), customer.name.min()).from(customer).fetchOne();
    }
}
