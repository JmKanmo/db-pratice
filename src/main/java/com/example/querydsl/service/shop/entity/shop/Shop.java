package com.example.querydsl.service.shop.entity.shop;


import com.example.querydsl.service.shop.entity.product.Product;
import com.example.querydsl.service.shop.entity.review.ShopReview;
import com.example.querydsl.service.shop.entity.seller.Seller;
import com.example.querydsl.service.shop.input.shop.ShopInput;
import com.example.querydsl.util.RandomUtil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shop_id")
    private Long id;

    private String name;

    private long price;

    @Lob
    private String description;

    @CreatedDate
    private LocalDateTime registerTime;

    @LastModifiedDate
    private LocalDateTime updateTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seller_id")
    private Seller seller;

    @Fetch(FetchMode.SUBSELECT)
    @OneToMany(mappedBy = "shop")
    private List<Product> productList;

    @Fetch(FetchMode.SUBSELECT)
    @OneToMany(mappedBy = "shop")
    private List<ShopReview> shopReviewList;

    public static Shop from(long id, String name, long price, String description, long sellerId) {
        return Shop.builder()
                .id(id)
                .name(name)
                .price(price)
                .description(description)
                .seller(Seller.from(sellerId, RandomUtil.createRandomNickName(), RandomUtil.createRandomAddress()))
                .registerTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .build();
    }

    public static Shop from(ShopInput shopInput) {
        return Shop.builder()
                .id(shopInput.getId())
                .name(shopInput.getName())
                .price(shopInput.getPrice())
                .description(shopInput.getDescription())
                .registerTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .seller(Seller.from(
                        shopInput.getSellerId(),
                        RandomUtil.createRandomName(),
                        RandomUtil.createRandomAddress()))
                .build();
    }
}
