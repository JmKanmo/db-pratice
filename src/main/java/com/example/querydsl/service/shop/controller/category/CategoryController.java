package com.example.querydsl.service.shop.controller.category;

import com.example.querydsl.service.shop.entity.category.Category;
import com.example.querydsl.service.shop.repository.category.batch.JdbcCategoryBatchRepo;
import com.example.querydsl.service.shop.repository.category.jpa.CategoryRepository;
import com.example.querydsl.util.RandomUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CategoryController {
    private final JdbcCategoryBatchRepo categoryBatchRepo;
    private final CategoryRepository categoryRepository;

    @PostMapping("/insert/category")
    public ResponseEntity<?> batchCategoryInsert(@RequestParam(value = "insertCount", defaultValue = "0", required = false) String insertCount,
                                                 @RequestParam(value = "batchCount", defaultValue = "0", required = false) String batchCount) {
        try {
            final List<Category> categories = new ArrayList<>();

            long count = categoryRepository.count();

            for (int i = 1; i <= Integer.parseInt(insertCount); i++) {
                categories.add(Category.from(count + i, RandomUtil.createRandomName()));
            }
            categoryBatchRepo.saveAllCustomer(categories, Integer.parseInt(batchCount));
            return ResponseEntity.ok(200);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok(500);
        }
    }
}
