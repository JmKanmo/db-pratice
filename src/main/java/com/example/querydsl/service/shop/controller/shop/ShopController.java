package com.example.querydsl.service.shop.controller.shop;

import com.example.querydsl.service.shop.input.shop.ShopInput;
import com.example.querydsl.service.shop.service.shop.ShopService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class ShopController {
    private final ShopService shopService;

    @Operation(summary = "shop insert api", description = "shop auto insert api")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "success"),
            @ApiResponse(responseCode = "500", description = "fail")
    })
    @PostMapping("/insert/auto/shop")
    public ResponseEntity<?> batchShopInsert(@RequestParam(value = "insertCount", defaultValue = "0", required = false) String insertCount,
                                             @RequestParam(value = "batchCount", defaultValue = "0", required = false) String batchCount) {
        shopService.autoInsertShop(insertCount, batchCount);
        return ResponseEntity.ok(200);
    }

    @Operation(summary = "shop custom insert api", description = "shop custom insert api")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "success"),
            @ApiResponse(responseCode = "500", description = "fail")
    })
    @PostMapping("/insert/custom/shop")
    public ResponseEntity<?> customShopInsert(@RequestBody @Valid ShopInput shopInput) {
        shopService.customInsertShop(shopInput);
        return ResponseEntity.ok(200);
    }
}
