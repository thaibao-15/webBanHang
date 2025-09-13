package com.example.BanHang.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.BanHang.entity.CartItem;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem,String> {

    List<CartItem> findByCart_Id(Integer cartId);

}
