package com.example.querydsl.service.shop.input.customer;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
public class CustomerInput {
    private final Long id;

    @NotNull
    @NotEmpty
    private final String name;

    @NotNull
    @NotEmpty
    private final String phone;
    private final long money;

    @NotNull
    @NotEmpty
    private final String address;

    @NotNull
    @NotEmpty
    private final String birth;
}
