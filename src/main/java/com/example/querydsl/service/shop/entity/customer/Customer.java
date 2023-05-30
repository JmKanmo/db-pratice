package com.example.querydsl.service.shop.entity.customer;

import com.example.querydsl.service.shop.entity.review.ProductReview;
import com.example.querydsl.service.shop.input.customer.CustomerInput;
import lombok.*;
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
public class Customer {
    @Id
    @Column(name = "customer_id", updatable = false)
    @EqualsAndHashCode.Include
    private Long id;

    @Column
    private String name;

    private String phone;

    private long money;

    private String address;

    private String birth;

    @Fetch(FetchMode.SUBSELECT)
    @OneToMany(mappedBy = "customer")
    private List<ProductReview> productReviewList;

    @CreatedDate
    private LocalDateTime registerTime;

    @LastModifiedDate
    private LocalDateTime updateTime;

    public static Customer from(long id, String name, String phone, String address, String birth, long money) {
        Customer customer = Customer.builder()
                .id(id)
                .name(name)
                .phone(phone)
                .address(address)
                .money(money)
                .registerTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .birth(birth)
                .build();
        return customer;
    }

    public static Customer from(CustomerInput customerInput) {
        return Customer.builder()
                .id(customerInput.getId())
                .name(customerInput.getName())
                .phone(customerInput.getPhone())
                .address(customerInput.getAddress())
                .money(customerInput.getMoney())
                .registerTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .birth(customerInput.getBirth())
                .build();
    }
}
