package com.example.BanHang.mapper;

import com.example.BanHang.dto.request.OrderCreationRequest;
import com.example.BanHang.dto.request.OrderUpdateRequest;
import com.example.BanHang.dto.response.OrderResponse;
import com.example.BanHang.entity.Cart;
import com.example.BanHang.entity.CartItem;
import com.example.BanHang.entity.Order;
import com.example.BanHang.entity.OrderDetail;
import com.example.BanHang.entity.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-12T16:56:46+0700",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.43.0.v20250819-1513, environment: Java 21.0.8 (Eclipse Adoptium)"
)
@Component
public class OrderMapperImpl implements OrderMapper {

    @Override
    public Order toOrder(OrderCreationRequest request) {
        if ( request == null ) {
            return null;
        }

        Order.OrderBuilder order = Order.builder();

        return order.build();
    }

    @Override
    public OrderResponse toOderResponse(Order order) {
        if ( order == null ) {
            return null;
        }

        OrderResponse.OrderResponseBuilder orderResponse = OrderResponse.builder();

        orderResponse.userId( orderUserId( order ) );
        orderResponse.totalAmount( order.getTotalAmount() );
        orderResponse.status( order.getStatus() );
        orderResponse.orderDate( order.getOrderDate() );

        return orderResponse.build();
    }

    @Override
    public void updateOrder(Order order, OrderUpdateRequest request) {
        if ( request == null ) {
            return;
        }

        order.setStatus( request.getStatus() );
    }

    @Override
    public Order toOrders(Cart cart) {
        if ( cart == null ) {
            return null;
        }

        Order.OrderBuilder order = Order.builder();

        order.user( cart.getUser() );

        return order.build();
    }

    @Override
    public List<OrderDetail> toOrderDetail(List<CartItem> cartItem) {
        if ( cartItem == null ) {
            return null;
        }

        List<OrderDetail> list = new ArrayList<OrderDetail>( cartItem.size() );
        for ( CartItem cartItem1 : cartItem ) {
            list.add( toOrderDetail( cartItem1 ) );
        }

        return list;
    }

    @Override
    public OrderDetail toOrderDetail(CartItem cartItem) {
        if ( cartItem == null ) {
            return null;
        }

        OrderDetail.OrderDetailBuilder orderDetail = OrderDetail.builder();

        orderDetail.products( cartItem.getProducts() );
        orderDetail.quantity( cartItem.getQuantity() );

        return orderDetail.build();
    }

    private String orderUserId(Order order) {
        if ( order == null ) {
            return null;
        }
        User user = order.getUser();
        if ( user == null ) {
            return null;
        }
        String id = user.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
