package com.example.BanHang.service;

import com.example.BanHang.dto.request.CartItemCreationRequest;
import com.example.BanHang.dto.response.CartItemResponse;
import com.example.BanHang.entity.Cart;
import com.example.BanHang.entity.CartItem;
import com.example.BanHang.exception.AppException;
import com.example.BanHang.exception.ErrorCode;
import com.example.BanHang.mapper.CartItemMapper;
import com.example.BanHang.repository.CartItemRepository;
import com.example.BanHang.repository.CartRepository;
import com.example.BanHang.repository.ProductRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class CartItemService {
    CartItemMapper cartItemMapper;
    CartItemRepository cartItemRepository;

    CartRepository cartRepository;
    ProductRepository productRepository;

    public CartItemResponse createCartItem(CartItemCreationRequest request){
        Cart cart = cartRepository.findById(String.valueOf(request.getCartId())).orElseThrow(() ->
                new AppException(ErrorCode.CART_NOT_EXIST));
        productRepository.findById(String.valueOf(request.getProductId())).orElseThrow(() ->
                new AppException(ErrorCode.PRODUCT_NOT_EXIST));

        CartItem cartItem = cartItemMapper.toCartItem(request);
        cartItemRepository.save(cartItem);

        return cartItemMapper.toCartItemResponse(cartItem);
    }
}
