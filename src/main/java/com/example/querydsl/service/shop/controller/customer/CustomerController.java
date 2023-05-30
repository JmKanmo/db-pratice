package com.example.querydsl.service.shop.controller.customer;

import com.example.querydsl.service.shop.input.customer.CustomerInput;
import com.example.querydsl.service.shop.service.customer.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping("/insert/auto/customer")
    public ResponseEntity<?> batchCustomerInsert(@RequestParam(value = "insertCount", defaultValue = "0", required = false) String insertCount,
                                                 @RequestParam(value = "batchCount", defaultValue = "0", required = false) String batchCount) {
        customerService.autoInsertCustomer(insertCount, batchCount);
        return ResponseEntity.ok(200);
    }

    @PostMapping("/insert/custom/customer")
    public ResponseEntity<?> cuscomCustomerInsert(@RequestBody CustomerInput customerInput) {
        customerService.customInsertCustomer(customerInput);
        return ResponseEntity.ok(200);
    }
}
