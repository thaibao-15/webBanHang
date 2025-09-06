package com.example.BanHang.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CartItemResponse {

    Long cartId;

    Integer productId;   // tham chiếu sản phẩm

    String productName;

    String image;


    Integer quantity;
}
