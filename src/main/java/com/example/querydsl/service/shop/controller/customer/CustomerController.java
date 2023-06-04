package com.example.querydsl.service.shop.controller.customer;

import com.example.querydsl.service.shop.input.customer.CustomerInput;
import com.example.querydsl.service.shop.service.customer.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Tag(name = "customer", description = "customer rest api")
@RestController
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @Operation(summary = "customer insert api", description = "customer auto insert api")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "success"),
            @ApiResponse(responseCode = "500", description = "fail")
    })
    @PostMapping("/insert/auto/customer")
    public ResponseEntity<?> batchCustomerInsert(@RequestParam(value = "insertCount", defaultValue = "0", required = false) String insertCount,
                                                 @RequestParam(value = "batchCount", defaultValue = "0", required = false) String batchCount) {
        customerService.autoInsertCustomer(insertCount, batchCount);
        return ResponseEntity.ok(200);
    }

    @Operation(summary = "customer custom insert api", description = "customer custom insert api")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "success"),
            @ApiResponse(responseCode = "500", description = "fail")
    })
    @PostMapping("/insert/custom/customer")
    public ResponseEntity<?> customCustomerInsert(@RequestBody @Valid CustomerInput customerInput) {
        customerService.customInsertCustomer(customerInput);
        return ResponseEntity.ok(200);
    }
}
