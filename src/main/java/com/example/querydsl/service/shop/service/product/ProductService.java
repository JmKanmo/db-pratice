package com.example.querydsl.service.shop.service.product;

import com.example.querydsl.service.shop.entity.product.Product;
import com.example.querydsl.service.shop.input.product.ProductInput;
import com.example.querydsl.service.shop.repository.product.batch.JdbcProductBatchRepo;
import com.example.querydsl.service.shop.repository.product.jpa.ProductRepository;
import com.example.querydsl.service.shop.service.category.CategoryService;
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
public class ProductService {
    private final JdbcProductBatchRepo jdbcProductBatchRepo;
    private final ProductRepository productRepository;
    private final ShopService shopService;
    private final CategoryService categoryService;

    @Transactional
    public void autoInsertProduct(String insertCount, String batchCount) {
        final List<Product> productList = new ArrayList<>();
        final long productCount = productRepository.count();
        final long shopCount = shopService.getShopCount();
        final long categoryCount = categoryService.getCategoryCount();
        final long shopNumber = RandomUtil.createRandomNumber(1L, shopCount);
        final long categoryNumber = RandomUtil.createRandomNumber(1L, categoryCount);

        for (int i = 1; i <= Integer.parseInt(insertCount); i++) {
            productList.add(Product.from(
                    productCount + i
                    , RandomUtil.createRandomNickName(),
                    RandomUtil.createRandomMoney(),
                    RandomUtil.createRandomCount(),
                    categoryNumber,
                    shopNumber));
        }
        jdbcProductBatchRepo.saveAllProduct(productList, Integer.parseInt(batchCount));
    }

    @Transactional
    public void customInsertShop(ProductInput productInput) {
        productRepository.save(Product.from(productInput));
    }

    public long getProductCount() {
        return productRepository.count();
    }
}
