package com.example.BanHang.repository;

import com.example.BanHang.entity.Cart;
import com.example.BanHang.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem,String> {

    List<CartItem> findByCart_Id(Integer cartId);


}
