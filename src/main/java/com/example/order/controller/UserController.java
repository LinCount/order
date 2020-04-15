package com.example.order.controller;

import com.example.order.entity.User;
import com.example.order.service.UserService;
import com.example.order.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value ="/user" )
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping(value = "/getUser",method = RequestMethod.GET)
    public ResultUtil getUserByid(){
        System.out.println("测试获取用户");
        return new ResultUtil(200,"查询成功",userService.findUserById("12341234"));
    }
    @RequestMapping(value = "/getAllUser",method = RequestMethod.GET)
    public List<User> getAllUser(){
        return userService.getAllUser();
    }
}
