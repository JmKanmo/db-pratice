package com.example.querydsl.service.shop.entity.seller;

import com.example.querydsl.service.shop.entity.shop.Shop;
import com.example.querydsl.service.shop.input.seller.SellerInput;
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
@Table(name = "seller", indexes = {
        @Index(name = "seller_idx_name", columnList = "name"),
        @Index(name = "seller_idx_address", columnList = "address")
})
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seller_id")
    private Long id;

    private String name;

    private String address;

    @Fetch(FetchMode.SUBSELECT)
    @OneToMany(mappedBy = "seller")
    private List<Shop> shopList;

    @CreatedDate
    private LocalDateTime registerTime;

    @LastModifiedDate
    private LocalDateTime updateTime;

    public static Seller from(long id, String name, String address) {
        return Seller.builder()
                .id(id)
                .name(name)
                .address(address)
                .registerTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .build();
    }

    public static Seller from(SellerInput sellerInput) {
        return Seller.builder()
                .id(sellerInput.getId())
                .name(sellerInput.getName())
                .address(sellerInput.getAddress())
                .registerTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .build();
    }
}
