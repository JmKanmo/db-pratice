package com.example.querydsl.service.shop.controller.review;

import com.example.querydsl.service.shop.input.review.ProductReviewInput;
import com.example.querydsl.service.shop.service.review.ProductReviewService;
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
public class ProductReviewController {
    private final ProductReviewService productReviewService;

    @Operation(summary = "product review auto insert api", description = "product review auto insert api")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "success"),
            @ApiResponse(responseCode = "500", description = "fail")
    })
    @PostMapping("/insert/auto/product-review")
    public ResponseEntity<?> batchProductReviewInsert(@RequestParam(value = "insertCount", defaultValue = "0", required = false) String insertCount,
                                                      @RequestParam(value = "batchCount", defaultValue = "0", required = false) String batchCount) {
        try {
            productReviewService.autoInsertProductReview(insertCount, batchCount);
            return ResponseEntity.ok(200);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok(500);
        }
    }

    @Operation(summary = "product review custom insert api", description = "product review custom insert api")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "success"),
            @ApiResponse(responseCode = "500", description = "fail")
    })
    @PostMapping("/insert/custom/product-review")
    public ResponseEntity<?> customProductReviewInsert(@RequestBody @Valid ProductReviewInput productReviewInput) {
        productReviewService.customInsertProductReview(productReviewInput);
        return ResponseEntity.ok(200);
    }
}
