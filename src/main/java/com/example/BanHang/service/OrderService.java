package com.example.BanHang.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.example.BanHang.dto.request.OrderCreationRequest;
import com.example.BanHang.dto.response.OrderResponse;
import com.example.BanHang.entity.Order;
import com.example.BanHang.entity.User;
import com.example.BanHang.exception.AppException;
import com.example.BanHang.exception.ErrorCode;
import com.example.BanHang.mapper.OrderMapper;
import com.example.BanHang.repository.OrderRepository;
import com.example.BanHang.repository.UserRepository;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class OrderService {
    OrderRepository orderRepository;
    OrderMapper orderMapper;
    UserRepository userRepository;

    public OrderResponse createOrder(OrderCreationRequest request){
        User user= userRepository.findById(request.getUserId()).orElseThrow(
                () -> new AppException(ErrorCode.USER_NOT_EXISTED));
        Order order = orderMapper.toOrder(request);
        order.setUser(user);
        order.setOrderDate(LocalDateTime.now());
        order.setStatus("PENDING");
        if (request.getTotal() != null) {
            order.setTotalAmount(BigDecimal.valueOf(request.getTotal()));
        }
        orderRepository.save(order);

        return  orderMapper.toOderResponse(order);

    }
}
