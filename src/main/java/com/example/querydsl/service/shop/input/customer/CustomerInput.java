package com.example.querydsl.service.shop.input.customer;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerInput {
    private Long id;
    private String name;
    private String phone;
    private long money;
    private String address;
    private String birth;
}
