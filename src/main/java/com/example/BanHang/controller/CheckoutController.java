package com.example.BanHang.controller;

import com.example.BanHang.dto.request.ApiResponse;
import com.example.BanHang.dto.response.OrderResponse;
import com.example.BanHang.service.OrderService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/checkout")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class CheckoutController {
    OrderService orderService;

    @PostMapping("/{id}")
    ApiResponse<OrderResponse> checkout(@PathVariable String id){
        return ApiResponse.<OrderResponse>builder()
                .result(orderService.createOrderAndOrderDetailFromCart(id))
                .build();
    }
}
