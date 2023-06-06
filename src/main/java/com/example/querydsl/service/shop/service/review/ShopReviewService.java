package com.example.querydsl.service.shop.service.review;

import com.example.querydsl.service.shop.entity.review.ShopReview;
import com.example.querydsl.service.shop.input.review.ShopReviewInput;
import com.example.querydsl.service.shop.repository.review.batch.JdbcShopReviewBatchRepo;
import com.example.querydsl.service.shop.repository.review.jpa.ShopReviewRepository;
import com.example.querydsl.service.shop.service.customer.CustomerService;
import com.example.querydsl.service.shop.service.seller.SellerService;
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
public class ShopReviewService {
    private final JdbcShopReviewBatchRepo jdbcShopReviewBatchRepo;
    private final ShopReviewRepository shopReviewRepository;
    private final CustomerService customerService;
    private final ShopService shopService;
    private final SellerService sellerService;

    @Transactional
    public void autoInsertShopReview(String insertCount, String batchCount) {
        final List<ShopReview> shopReviewList = new ArrayList<>();
        final long shopReviewCount = shopReviewRepository.count();
        final long customerCount = customerService.getCustomerCount();
        final long customerNumber = RandomUtil.createRandomNumber(1L, customerCount);
        final long shopCount = shopService.getShopCount();
        final long shopNumber = RandomUtil.createRandomNumber(1L, shopCount);
        final long sellerCount = sellerService.getSellerCount();
        final long sellerNumber = RandomUtil.createRandomNumber(1L, sellerCount);

        for (int i = 1; i <= Integer.parseInt(insertCount); i++) {
            shopReviewList.add(ShopReview.from(
                    shopReviewCount + i
                    , RandomUtil.createRandomString(1000)
                    , RandomUtil.createRandomNumber(Long.MIN_VALUE, Long.MAX_VALUE)
                    , customerNumber
                    , shopNumber
                    , sellerNumber));
        }
        jdbcShopReviewBatchRepo.saveAllShopReview(shopReviewList, Integer.parseInt(batchCount));
    }

    @Transactional
    public void customInsertShopReview(ShopReviewInput shopReviewInput) {
        shopReviewRepository.save(ShopReview.from(shopReviewInput));
    }

    public long getShopReviewCount() {
        return shopReviewRepository.count();
    }
}
