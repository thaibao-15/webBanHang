package com.example.BanHang.mapper;

import com.example.BanHang.dto.request.OrderCreationRequest;
import com.example.BanHang.dto.request.OrderUpdateRequest;
import com.example.BanHang.dto.response.OrderResponse;
import com.example.BanHang.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    Order toOrder(OrderCreationRequest request);

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "totalAmount", target = "totalAmount")
    @Mapping(source = "status", target = "status")
    OrderResponse toOderResponse(Order order);

    void updateOrder(@MappingTarget Order order, OrderUpdateRequest request);
}
