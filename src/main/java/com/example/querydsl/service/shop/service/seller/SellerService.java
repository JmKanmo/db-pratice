package com.example.querydsl.service.shop.service.seller;

import com.example.querydsl.service.shop.entity.seller.Seller;
import com.example.querydsl.service.shop.input.seller.SellerInput;
import com.example.querydsl.service.shop.repository.seller.batch.JdbcSellerBatchRepo;
import com.example.querydsl.service.shop.repository.seller.jpa.SellerRepository;
import com.example.querydsl.util.RandomUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SellerService {
    private final JdbcSellerBatchRepo jdbcSellerBatchRepo;
    private final SellerRepository sellerRepository;

    @Transactional
    public void autoInsertSeller(String insertCount, String batchCount) {
        final List<Seller> sellerList = new ArrayList<>();


        long count = sellerRepository.count();

        for (int i = 1; i <= Integer.parseInt(insertCount); i++) {
            sellerList.add(Seller.from(count + i,
                    RandomUtil.createRandomName(),
                    RandomUtil.createRandomAddress()
            ));
        }
        jdbcSellerBatchRepo.saveAllCustomer(sellerList, Integer.parseInt(batchCount));
    }

    @Transactional
    public void customInsertSeller(SellerInput sellerInput) {
        sellerRepository.save(Seller.from(sellerInput));
    }

    public long getSellerCount() {
        return sellerRepository.count();
    }
}
