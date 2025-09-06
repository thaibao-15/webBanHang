package com.example.BanHang.controller;

import com.example.BanHang.dto.request.ApiResponse;
import com.example.BanHang.dto.request.CartItemCreationRequest;
import com.example.BanHang.dto.response.CartItemResponse;
import com.example.BanHang.service.CartItemService;
import com.example.BanHang.service.CartService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cartItems")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class CartItemController {
    CartItemService cartItemService;
    @PostMapping
    ApiResponse<CartItemResponse> createCartItem(@RequestBody CartItemCreationRequest request){
        return ApiResponse.<CartItemResponse>builder()
                .result(cartItemService.createCartItem(request))
                .build();
    }
}
