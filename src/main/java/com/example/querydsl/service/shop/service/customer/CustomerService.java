package com.example.querydsl.service.shop.service.customer;

import com.example.querydsl.service.shop.entity.customer.Customer;
import com.example.querydsl.service.shop.input.customer.CustomerInput;
import com.example.querydsl.service.shop.repository.customer.batch.JdbcCustomerBatchRepo;
import com.example.querydsl.service.shop.repository.customer.jpa.CustomerRepository;
import com.example.querydsl.util.RandomUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CustomerService {
    private final JdbcCustomerBatchRepo jdbcCustomerBatchRepo;
    private final CustomerRepository customerRepository;

    @Transactional
    public void autoInsertCustomer(String insertCount, String batchCount) {
        final List<Customer> IDENTITYCustomerList = new ArrayList<>();

        long count = customerRepository.count();

        for (int i = 1; i <= Integer.parseInt(insertCount); i++) {
            IDENTITYCustomerList.add(Customer.from(count + i,
                    RandomUtil.createRandomName(),
                    RandomUtil.createRandomPhoneNumber(),
                    RandomUtil.createRandomAddress(),
                    RandomUtil.createRandomBirthDate(),
                    566500));
        }
        jdbcCustomerBatchRepo.saveAllCustomer(IDENTITYCustomerList, Integer.parseInt(batchCount));
    }

    @Transactional
    public void customInsertCustomer(CustomerInput customerInput) {
        customerRepository.save(Customer.from(customerInput));
    }
}
