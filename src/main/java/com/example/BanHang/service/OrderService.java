package com.example.BanHang.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.example.BanHang.dto.request.OrderUpdateRequest;
import com.example.BanHang.entity.*;
import com.example.BanHang.repository.*;
import org.springframework.stereotype.Service;

import com.example.BanHang.dto.request.OrderCreationRequest;
import com.example.BanHang.dto.response.OrderResponse;
import com.example.BanHang.exception.AppException;
import com.example.BanHang.exception.ErrorCode;
import com.example.BanHang.mapper.OrderMapper;

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

    CartRepository cartRepository;
    CartItemRepository cartItemRepository;

    OrderDetailRepository orderDetailRepository;


    public OrderResponse createOrder(OrderCreationRequest request){
        User user= userRepository.findById(request.getUserId()).orElseThrow(
                () -> new AppException(ErrorCode.USER_NOT_EXISTED));
        Order order = orderMapper.toOrder(request);
        order.setUser(user);
        order.setOrderDate(LocalDateTime.now());
        order.setDateUpdate(LocalDateTime.now());
        order.setStatus("PENDING");
        if (request.getTotal() != null) {
            order.setTotalAmount(BigDecimal.valueOf(request.getTotal()));
        }
        orderRepository.save(order);

        return  orderMapper.toOderResponse(order);
    }
    public OrderResponse updateOrder(OrderUpdateRequest request,Integer orderId){
        Order order =orderRepository.findById(orderId).orElseThrow(
                () -> new AppException(ErrorCode.ORDER_NOT_EXIST));

        orderMapper.updateOrder(order,request);
        order.setDateUpdate(LocalDateTime.now());
        orderRepository.save(order);

        return orderMapper.toOderResponse(order);
    }

    public OrderResponse createOrderAndOrderDetailFromCart(String cartId){
        Cart cart =cartRepository.findById(cartId).orElseThrow(
                () -> new AppException(ErrorCode.CART_NOT_EXIST));

        Order order= orderMapper.toOrders(cart);
        order.setStatus("PENDIND");
        order.setOrderDate(LocalDateTime.now());
        order.setDateUpdate(LocalDateTime.now());

//        List<OrderDetail> list =orderDetailRepository.findByOrder_Id(order.getId());

    //        List<CartItem> listCartItem = cartItemRepository.findByCart_Id(cart.getId());
    //
    //
    //        List<OrderDetail> listOrderDetail = orderMapper.toOrderDetail(listCartItem);

        List<OrderDetail> details = cart.getItems().stream()
                .map(orderMapper::toOrderDetail)
                .toList();

        details.forEach(d -> d.setOrder(order));
        order.setOrderDetails(details);


        orderRepository.save(order);


        return orderMapper.toOderResponse(order);

    }

}
