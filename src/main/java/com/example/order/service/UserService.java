package com.example.order.service;

import com.example.order.entity.User;
import com.example.order.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    public User findUserById(String id){
        return userMapper.findUserById(id);
    }
    public List<User> getAllUser(){
        return userMapper.getAllUser();
    }
}
