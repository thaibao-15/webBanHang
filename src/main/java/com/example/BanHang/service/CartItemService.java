package com.example.BanHang.service;

import java.util.List;

import com.example.BanHang.dto.request.CartItemUpdateRequest;
import org.springframework.stereotype.Service;

import com.example.BanHang.dto.request.CartItemCreationRequest;
import com.example.BanHang.dto.request.DeleteCartItemRequest;
import com.example.BanHang.dto.response.CartItemResponse;
import com.example.BanHang.entity.Cart;
import com.example.BanHang.entity.CartItem;
import com.example.BanHang.entity.Product;
import com.example.BanHang.exception.AppException;
import com.example.BanHang.exception.ErrorCode;
import com.example.BanHang.mapper.CartItemMapper;
import com.example.BanHang.repository.CartItemRepository;
import com.example.BanHang.repository.CartRepository;
import com.example.BanHang.repository.ProductRepository;
import com.example.BanHang.repository.UserRepository;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class CartItemService {
    CartItemMapper cartItemMapper;
    CartItemRepository cartItemRepository;

    CartRepository cartRepository;
    ProductRepository productRepository;
    UserRepository userRepository;

    public CartItemResponse createCartItem(CartItemCreationRequest request){
        Cart cart = cartRepository.findById(String.valueOf(request.getCartId())).orElseThrow(() ->
                new AppException(ErrorCode.CART_NOT_EXIST));
        Product product = productRepository.findById(String.valueOf(request.getProductId())).orElseThrow(() ->
                new AppException(ErrorCode.PRODUCT_NOT_EXIST));

        CartItem cartItem = cartItemMapper.toCartItem(request);
        cartItem.setProducts(product);
        cartItem.setCart(cart);

        cartItemRepository.save(cartItem);

        return cartItemMapper.toCartItemResponse(cartItem);
    }

    public List<CartItemResponse> getAllCartItems(String userid){
        userRepository.findById(userid).orElseThrow(
                () -> new AppException(ErrorCode.USER_NOT_EXISTED));

        Cart cart = cartRepository.findByUser_Id(userid);

        List<CartItem> items = cartItemRepository.findByCart_Id(cart.getId());
        return cartItemMapper.toCartItemList(items);
    }
    public void deleteCartItem(DeleteCartItemRequest request){
        cartItemRepository.findById(request.getId()).orElseThrow(
                () -> new AppException(ErrorCode.CARTITEM_NOT_EXIST));

        cartItemRepository.deleteById(request.getId());
    }
    public void deleleteCartItemByListId(List<String> id){
        cartItemRepository.deleteAllById(id);
    }

    public CartItemResponse updateCartItem(CartItemUpdateRequest request){
        CartItem cartItem= cartItemRepository.findById(request.getId()).orElseThrow(
                () -> new AppException(ErrorCode.CARTITEM_NOT_EXIST));
        cartItemMapper.updateCartItem(cartItem,request);

        cartItemRepository.save(cartItem);

        return cartItemMapper.toCartItemResponse(cartItem);
    }
}
