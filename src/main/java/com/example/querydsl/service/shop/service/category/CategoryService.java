package com.example.querydsl.service.shop.service.category;

import com.example.querydsl.service.shop.entity.category.Category;
import com.example.querydsl.service.shop.input.category.CategoryInput;
import com.example.querydsl.service.shop.repository.category.batch.JdbcCategoryBatchRepo;
import com.example.querydsl.service.shop.repository.category.jpa.CategoryRepository;
import com.example.querydsl.util.RandomUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CategoryService {
    private final JdbcCategoryBatchRepo jdbcCategoryBatchRepo;
    private final CategoryRepository categoryRepository;

    @Transactional
    public void autoInsertShop(String insertCount, String batchCount) {
        final List<Category> categoryList = new ArrayList<>();
        final long categoryCount = categoryRepository.count();

        for (int i = 1; i <= Integer.parseInt(insertCount); i++) {
            categoryList.add(Category.from(categoryCount + i
                    , RandomUtil.createRandomName()));
        }
        jdbcCategoryBatchRepo.saveAllCustomer(categoryList, Integer.parseInt(batchCount));
    }

    @Transactional
    public void customInsertShop(CategoryInput categoryInput) {
        categoryRepository.save(Category.from(categoryInput));
    }

    public long getCategoryCount() {
        return categoryRepository.count();
    }
}
