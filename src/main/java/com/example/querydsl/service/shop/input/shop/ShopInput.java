package com.example.querydsl.service.shop.input.shop;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
public class ShopInput {
    private final long id;

    @NotNull
    @NotEmpty
    private final String name;

    private final long price;

    @NotNull
    @NotEmpty
    private final String description;

    private final long sellerId;
}
