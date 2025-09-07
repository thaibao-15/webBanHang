package com.example.BanHang.controller;

import com.example.BanHang.dto.request.ApiResponse;
import com.example.BanHang.dto.request.CartCreationRequest;
import com.example.BanHang.dto.request.CartItemCreationRequest;
import com.example.BanHang.dto.response.CartItemResponse;
import com.example.BanHang.dto.response.CartResponse;
import com.example.BanHang.service.CartItemService;
import com.example.BanHang.service.CartService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/{id}")
    ApiResponse<List<CartItemResponse>> getAllCartItems(@PathVariable String id){
        return ApiResponse.<List<CartItemResponse>>builder()
                .result(cartItemService.getAllCartItems(id))
                .build();
    }
}
