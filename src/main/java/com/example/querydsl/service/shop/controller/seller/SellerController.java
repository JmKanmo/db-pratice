package com.example.querydsl.service.shop.controller.seller;

import com.example.querydsl.service.shop.input.seller.SellerInput;
import com.example.querydsl.service.shop.service.seller.SellerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Tag(name = "seller", description = "seller rest api")
@RestController
@RequiredArgsConstructor
public class SellerController {
    private final SellerService sellerService;

    @Operation(summary = "seller insert api", description = "seller auto insert api")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "success"),
            @ApiResponse(responseCode = "500", description = "fail")
    })
    @PostMapping("/insert/auto/seller")
    public ResponseEntity<?> batchSellerInsert(@RequestParam(value = "insertCount", defaultValue = "0", required = false) String insertCount,
                                               @RequestParam(value = "batchCount", defaultValue = "0", required = false) String batchCount) {
        sellerService.autoInsertSeller(insertCount, batchCount);
        return ResponseEntity.ok(200);
    }

    @Operation(summary = "seller custom insert api", description = "seller custom insert api")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "success"),
            @ApiResponse(responseCode = "500", description = "fail")
    })
    @PostMapping("/insert/custom/seller")
    public ResponseEntity<?> customSellerInsert(@RequestBody @Valid SellerInput sellerInput) {
        sellerService.customInsertSeller(sellerInput);
        return ResponseEntity.ok(200);
    }
}
