package com.example.querydsl.shop.controller;

import com.example.querydsl.shop.repository.CategoryRepository;
import com.example.querydsl.shop.repository.CustomerRepository;
import com.example.querydsl.shop.repository.batch.JdbcCategoryBatchRepo;
import com.example.querydsl.shop.repository.batch.JdbcCustomerBatchRepo;
import com.example.querydsl.shop.entity.Category;
import com.example.querydsl.shop.entity.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ShopBatchController {
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
        try {
            final List<Category> categories = new ArrayList<>();

            long count = categoryRepository.count();

            for (int i = 1; i <= Integer.parseInt(insertCount); i++) {
                categories.add(new Category(count + i, "과자 유제품 짱구 냠냠" + i, LocalDateTime.now(), LocalDateTime.now()));
            }
            categoryBatchRepo.saveAllCustomer(categories, Integer.parseInt(batchCount));
            return ResponseEntity.ok(200);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok(500);
        }
    }
}
