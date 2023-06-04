package com.example.querydsl.service.shop.controller.shop;

import com.example.querydsl.service.shop.service.shop.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ShopController {
    private final ShopService shopService;

}
