package com.example.BanHang.repository;

import com.example.BanHang.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
    boolean existsByUsername(String username);

}
