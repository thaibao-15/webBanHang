package com.example.BanHang.service;

import com.example.BanHang.dto.request.UserCreationRequest;
import com.example.BanHang.dto.request.UserUpdateRequest;
import com.example.BanHang.dto.response.UserResponse;
import com.example.BanHang.entity.User;
import com.example.BanHang.exception.AppException;
import com.example.BanHang.exception.ErrorCode;
import com.example.BanHang.mapper.UserMapper;
import com.example.BanHang.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class UserService {
    UserMapper userMapper;
    UserRepository userRepository;
    PasswordEncoder passwordEncoder =new BCryptPasswordEncoder();

    public UserResponse createUser(UserCreationRequest request){
        if(userRepository.existsByUsername(request.getUsername())){
            throw new AppException(ErrorCode.USER_EXISTED);
        }

        PasswordEncoder passwordEncoder =new BCryptPasswordEncoder();
        User user = userMapper.toUser(request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        userRepository.save(user);

        return userMapper.toUserResponse(user);
    }
    public List<UserResponse> getAllUsers(){
        return userRepository.findAll()
                .stream()
                .map(userMapper::toUserResponse)
                .toList();
    }
    public UserResponse getUser(String id){
        return userMapper.toUserResponse(userRepository.findById(id).orElseThrow(
                () -> new AppException(ErrorCode.USER_NOT_EXISTED)));
    }
    public void deleteUser(String id){
            userRepository.deleteById(id);
    }
    public UserResponse updateUser(String userId,UserUpdateRequest request){
        User user= userRepository.findById(userId).orElseThrow(
                () -> new AppException(ErrorCode.USER_NOT_EXISTED));
        userMapper.updateUser(user,request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        return userMapper.toUserResponse(userRepository.save(user));
    }
}


