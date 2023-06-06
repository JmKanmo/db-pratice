package com.example.querydsl.service.shop.input.product;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
public class ProductInput {
    private final long id;

    @NotNull
    @NotEmpty
    private final String name;

    private final long price;
    private final long count;
    private final long shopId;
    private final long categoryId;
    private final long sellerId;
}
