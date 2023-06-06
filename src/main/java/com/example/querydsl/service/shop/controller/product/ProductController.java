package com.example.querydsl.service.shop.controller.product;

import com.example.querydsl.service.shop.input.product.ProductInput;
import com.example.querydsl.service.shop.service.product.ProductService;
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
public class ProductController {
    private final ProductService productService;

    @Operation(summary = "product auto insert api", description = "product auto insert api")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "success"),
            @ApiResponse(responseCode = "500", description = "fail")
    })
    @PostMapping("/insert/auto/product")
    public ResponseEntity<?> batchProductInsert(@RequestParam(value = "insertCount", defaultValue = "0", required = false) String insertCount,
                                                @RequestParam(value = "batchCount", defaultValue = "0", required = false) String batchCount) {
        try {
            productService.autoInsertProduct(insertCount, batchCount);
            return ResponseEntity.ok(200);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok(500);
        }
    }

    @Operation(summary = "product custom insert api", description = "product custom insert api")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "success"),
            @ApiResponse(responseCode = "500", description = "fail")
    })
    @PostMapping("/insert/custom/product")
    public ResponseEntity<?> customProductInsert(@RequestBody @Valid ProductInput productInput) {
        productService.customInsertShop(productInput);
        return ResponseEntity.ok(200);
    }
}
