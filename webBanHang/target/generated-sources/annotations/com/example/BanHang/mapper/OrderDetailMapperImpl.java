package com.example.BanHang.mapper;

import com.example.BanHang.dto.request.OrderDetailCreationRequest;
import com.example.BanHang.dto.response.OrderDetailResponse;
import com.example.BanHang.entity.OrderDetail;
import com.example.BanHang.entity.Product;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-12T16:56:45+0700",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.43.0.v20250819-1513, environment: Java 21.0.8 (Eclipse Adoptium)"
)
@Component
public class OrderDetailMapperImpl implements OrderDetailMapper {

    @Override
    public OrderDetail toOrderDetail(OrderDetailCreationRequest request) {
        if ( request == null ) {
            return null;
        }

        OrderDetail.OrderDetailBuilder orderDetail = OrderDetail.builder();

        orderDetail.price( request.getPrice() );
        orderDetail.quantity( request.getQuantity() );

        return orderDetail.build();
    }

    @Override
    public OrderDetailResponse toOderDetailResponse(OrderDetail orderDetail) {
        if ( orderDetail == null ) {
            return null;
        }

        OrderDetailResponse.OrderDetailResponseBuilder orderDetailResponse = OrderDetailResponse.builder();

        orderDetailResponse.productName( orderDetailProductsName( orderDetail ) );
        BigDecimal price = orderDetailProductsPrice( orderDetail );
        if ( price != null ) {
            orderDetailResponse.priceProduct( price.doubleValue() );
        }
        orderDetailResponse.image( orderDetailProductsImage( orderDetail ) );
        orderDetailResponse.status( orderDetailProductsStatus( orderDetail ) );
        orderDetailResponse.price( orderDetail.getPrice() );
        orderDetailResponse.quantity( orderDetail.getQuantity() );

        return orderDetailResponse.build();
    }

    @Override
    public List<OrderDetailResponse> toOrderDetailList(List<OrderDetail> response) {
        if ( response == null ) {
            return null;
        }

        List<OrderDetailResponse> list = new ArrayList<OrderDetailResponse>( response.size() );
        for ( OrderDetail orderDetail : response ) {
            list.add( toOderDetailResponse( orderDetail ) );
        }

        return list;
    }

    private String orderDetailProductsName(OrderDetail orderDetail) {
        if ( orderDetail == null ) {
            return null;
        }
        Product products = orderDetail.getProducts();
        if ( products == null ) {
            return null;
        }
        String name = products.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private BigDecimal orderDetailProductsPrice(OrderDetail orderDetail) {
        if ( orderDetail == null ) {
            return null;
        }
        Product products = orderDetail.getProducts();
        if ( products == null ) {
            return null;
        }
        BigDecimal price = products.getPrice();
        if ( price == null ) {
            return null;
        }
        return price;
    }

    private String orderDetailProductsImage(OrderDetail orderDetail) {
        if ( orderDetail == null ) {
            return null;
        }
        Product products = orderDetail.getProducts();
        if ( products == null ) {
            return null;
        }
        String image = products.getImage();
        if ( image == null ) {
            return null;
        }
        return image;
    }

    private String orderDetailProductsStatus(OrderDetail orderDetail) {
        if ( orderDetail == null ) {
            return null;
        }
        Product products = orderDetail.getProducts();
        if ( products == null ) {
            return null;
        }
        String status = products.getStatus();
        if ( status == null ) {
            return null;
        }
        return status;
    }
}
