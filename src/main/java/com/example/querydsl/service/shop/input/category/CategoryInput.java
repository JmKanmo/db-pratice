package com.example.querydsl.service.shop.input.category;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
public class CategoryInput {
    private final long id;

    @NotNull
    @NotEmpty
    private final String name;
}
