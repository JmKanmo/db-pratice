package com.example.querydsl.service.shop.service.review;

import com.example.querydsl.service.shop.entity.review.ProductReview;
import com.example.querydsl.service.shop.input.review.ProductReviewInput;
import com.example.querydsl.service.shop.repository.review.batch.JdbcProductReviewBatchRepo;
import com.example.querydsl.service.shop.repository.review.jpa.ProductReviewRepository;
import com.example.querydsl.service.shop.service.category.CategoryService;
import com.example.querydsl.service.shop.service.customer.CustomerService;
import com.example.querydsl.service.shop.service.product.ProductService;
import com.example.querydsl.service.shop.service.shop.ShopService;
import com.example.querydsl.util.RandomUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductReviewService {
    private final JdbcProductReviewBatchRepo jdbcProductReviewBatchRepo;
    private final ProductReviewRepository productReviewRepository;
    private final CustomerService customerService;
    private final ProductService productService;
    private final ShopService shopService;
    private final CategoryService categoryService;

    @Transactional
    public void autoInsertProductReview(String insertCount, String batchCount) {
        final List<ProductReview> productReviewList = new ArrayList<>();
        final long productReviewCount = productReviewRepository.count();
        final long customerCount = customerService.getCustomerCount();
        final long customerNumber = RandomUtil.createRandomNumber(1L, customerCount);
        final long shopCount = shopService.getShopCount();
        final long shopNumber = RandomUtil.createRandomNumber(1L, shopCount);
        final long productCount = productService.getProductCount();
        final long productNumber = RandomUtil.createRandomNumber(1L, productCount);
        final long categoryCount = categoryService.getCategoryCount();
        final long categoryNumber = RandomUtil.createRandomNumber(1L, categoryCount);

        for (int i = 1; i <= Integer.parseInt(insertCount); i++) {
            productReviewList.add(ProductReview.from(
                    productReviewCount + i
                    , RandomUtil.createRandomString(1000)
                    , RandomUtil.createRandomNumber(1, 5)
                    , customerNumber
                    , productNumber
                    , categoryNumber
                    , shopNumber));
        }
        jdbcProductReviewBatchRepo.saveAllProductReview(productReviewList, Integer.parseInt(batchCount));
    }

    @Transactional
    public void customInsertProductReview(ProductReviewInput productReviewInput) {
        productReviewRepository.save(ProductReview.from(productReviewInput));
    }

    public long getProductReviewCount() {
        return productReviewRepository.count();
    }
}
