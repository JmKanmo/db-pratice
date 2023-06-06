package com.example.querydsl.service.shop.input.review;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
public class ProductReviewInput {
    private final long id;

    @NotNull
    @NotEmpty
    private final String content;

    private final long grade;

    private final long customerId;

    private final long productId;

    private final long categoryId;

    private final long shopId;
}
