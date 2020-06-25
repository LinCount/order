package com.example.order.service;

import com.example.order.entity.User;
import com.example.order.mapper.UserMapper;
import com.example.order.requestBean.UserBean;
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
    public User findUserByAccount(String account){
        return userMapper.findUserByAcount(account);
    }
    public Integer updatePwd(User user){
        return  userMapper.updatePwd(user);
    }
    public List<User> getAllUser(){
        return userMapper.getAllUser();
    }
    public Integer saveUser(User user){
        return userMapper.saveUser(user);
    }
}
