package com.example.querydsl.service.shop.input.seller;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Builder
@Data
public class SellerInput {
    private final Long id;

    @NotNull
    @NotEmpty
    private final String name;

    @NotNull
    @NotEmpty
    private final String address;
}
