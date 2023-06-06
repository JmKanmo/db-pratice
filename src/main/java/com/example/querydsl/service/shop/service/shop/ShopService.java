package com.example.querydsl.service.shop.service.shop;

import com.example.querydsl.service.shop.entity.shop.Shop;
import com.example.querydsl.service.shop.input.shop.ShopInput;
import com.example.querydsl.service.shop.repository.shop.batch.JdbcShopBatchRepo;
import com.example.querydsl.service.shop.repository.shop.jpa.ShopRepository;
import com.example.querydsl.service.shop.service.seller.SellerService;
import com.example.querydsl.util.RandomUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ShopService {
    private final ShopRepository shopRepository;
    private final SellerService sellerService;
    private final JdbcShopBatchRepo jdbcShopBatchRepo;

    @Transactional
    public void autoInsertShop(String insertCount, String batchCount) {
        final List<Shop> shopList = new ArrayList<>();
        final long shopCount = shopRepository.count();
        final long sellerCount = sellerService.getSellerCount();
        final long sellerNumber = RandomUtil.createRandomNumber(1L, sellerCount);

        for (int i = 1; i <= Integer.parseInt(insertCount); i++) {
            shopList.add(Shop.from(shopCount + i
                    , RandomUtil.createRandomNickName(),
                    RandomUtil.createRandomMoney(),
                    RandomUtil.createRandomString(1000),
                    sellerNumber));
        }
        jdbcShopBatchRepo.saveAllShop(shopList, Integer.parseInt(batchCount));
    }

    @Transactional
    public void customInsertShop(ShopInput shopInput) {
        shopRepository.save(Shop.from(shopInput));
    }

    public long getShopCount() {
        return shopRepository.count();
    }
}
