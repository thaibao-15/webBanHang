package com.example.BanHang.mapper;

import com.example.BanHang.dto.request.CartItemCreationRequest;
import com.example.BanHang.dto.response.CartItemResponse;
import com.example.BanHang.entity.CartItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CartItemMapper {
    @Mapping(source = "cartId", target = "cart.id")
    @Mapping(source = "productId", target = "products.id")
    CartItem toCartItem(CartItemCreationRequest request);

    @Mapping(source = "cart.id", target = "cartId")
    @Mapping(source = "products.id",target = "productId")
    @Mapping(source = "products.name", target = "productName")
    @Mapping(source = "products.image",target = "image")
    CartItemResponse toCartItemResponse(CartItem cartItem);
}
