package com.example.querydsl.controller;

import com.example.querydsl.entity.Category;
import com.example.querydsl.entity.Customer;
import com.example.querydsl.repository.CategoryRepository;
import com.example.querydsl.repository.CustomerRepository;
import com.example.querydsl.repository.batch.JdbcCategoryBatchRepo;
import com.example.querydsl.repository.batch.JdbcCustomerBatchRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/batch")
public class BatchController {
    private final JdbcCategoryBatchRepo categoryBatchRepo;
    private final JdbcCustomerBatchRepo jdbcCustomerBatchRepo;
    private final CustomerRepository customerRepository;

    private final CategoryRepository categoryRepository;

    @GetMapping("/insert/customer")
    public ResponseEntity<?> batchCustomerInsert(@RequestParam(value = "insertCount", defaultValue = "0", required = false) String insertCount,
                                                 @RequestParam(value = "batchCount", defaultValue = "0", required = false) String batchCount) {

        final List<Customer> IDENTITYCustomerList = new ArrayList<>();

        long count = customerRepository.count();

        for (int i = 1; i <= Integer.parseInt(insertCount); i++) {
            IDENTITYCustomerList.add(new Customer(count + i, "강준모" + count + i));
        }
        jdbcCustomerBatchRepo.saveAllCustomer(IDENTITYCustomerList, Integer.parseInt(batchCount));
        return ResponseEntity.ok(200);
    }

    @GetMapping("/insert/category")
    public ResponseEntity<?> batchCategoryInsert(@RequestParam(value = "insertCount", defaultValue = "0", required = false) String insertCount,
                                                 @RequestParam(value = "batchCount", defaultValue = "0", required = false) String batchCount) {

        final List<Category> categories = new ArrayList<>();

        long count = categoryRepository.count();

        for (int i = 1; i <= Integer.parseInt(insertCount); i++) {
            categories.add(new Category(count + i, "과자 유제품 짱구 냠냠" + i, LocalDateTime.now(), LocalDateTime.now()));
        }
        categoryBatchRepo.saveAllCustomer(categories, Integer.parseInt(batchCount));
        return ResponseEntity.ok(200);
    }

}
