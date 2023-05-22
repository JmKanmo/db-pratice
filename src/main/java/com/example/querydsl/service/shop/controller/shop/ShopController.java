package com.example.querydsl.service.shop.controller.shop;

import com.example.querydsl.service.shop.entity.category.Category;
import com.example.querydsl.service.shop.entity.customer.Customer;
import com.example.querydsl.service.shop.repository.category.batch.JdbcCategoryBatchRepo;
import com.example.querydsl.service.shop.repository.customer.jpa.CustomerRepository;
import com.example.querydsl.service.shop.repository.customer.batch.JdbcCustomerBatchRepo;
import com.example.querydsl.service.shop.repository.category.jpa.CategoryRepository;
import com.example.querydsl.util.BaseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ShopController {
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
            IDENTITYCustomerList.add(Customer.from(count + i,
                    BaseUtil.createRandomName(),
                    BaseUtil.createRandomPhoneNumber(),
                    BaseUtil.createRandomAddress(),
                    BaseUtil.createRandomBirthDate(),
                    566500));
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
                categories.add(Category.from(count + i, BaseUtil.createRandomName()));
            }
            categoryBatchRepo.saveAllCustomer(categories, Integer.parseInt(batchCount));
            return ResponseEntity.ok(200);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok(500);
        }
    }
}
