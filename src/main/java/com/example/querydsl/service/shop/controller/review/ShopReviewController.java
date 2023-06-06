package com.example.querydsl.service.shop.controller.review;

import com.example.querydsl.service.shop.input.review.ShopReviewInput;
import com.example.querydsl.service.shop.service.review.ShopReviewService;
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
public class ShopReviewController {
    private final ShopReviewService shopReviewService;

    @Operation(summary = "shop review auto insert api", description = "shop review auto insert api")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "success"),
            @ApiResponse(responseCode = "500", description = "fail")
    })
    @PostMapping("/insert/auto/shop-review")
    public ResponseEntity<?> batchShopReviewInsert(@RequestParam(value = "insertCount", defaultValue = "0", required = false) String insertCount,
                                                   @RequestParam(value = "batchCount", defaultValue = "0", required = false) String batchCount) {
        try {
            shopReviewService.autoInsertShopReview(insertCount, batchCount);
            return ResponseEntity.ok(200);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok(500);
        }
    }

    @Operation(summary = "shop review custom insert api", description = "shop review custom insert api")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "success"),
            @ApiResponse(responseCode = "500", description = "fail")
    })
    @PostMapping("/insert/custom/shop-review")
    public ResponseEntity<?> customShopReviewInsert(@RequestBody @Valid ShopReviewInput shopReviewInput) {
        shopReviewService.customInsertShopReview(shopReviewInput);
        return ResponseEntity.ok(200);
    }
}
