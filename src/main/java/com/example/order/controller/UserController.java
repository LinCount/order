package com.example.order.controller;

import com.example.order.Api.Response;
import com.example.order.Api.ResponseResult;
import com.example.order.Api.Token;
import com.example.order.requestBean.UserBean;
import com.example.order.entity.User;
import com.example.order.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value ="/user" )
public class UserController {
    @Autowired
    UserService userService;
    //登录接口
    @RequestMapping(value = "/login",
            method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8")
    public ResponseResult<Token> login(@RequestBody UserBean userBean){
        //检查必要字段格式
        //查询用户是否存在
        User user=userService.findUserByAccount(userBean.username);
        Token token=new Token();
        if(null!=user){
            if(userBean.username.equals(user.getAccount())&&userBean.pwd.equals(user.getPassword())){
                token.token=user.getToken();
                return Response.makeRsp(200,"登录成功",token);
            }else {
                return Response.makeRsp(400,"登录失败",token);
            }
        }else{
            return Response.makeRsp(400,"登录失败",token);
        }
    }
    //注册
    @RequestMapping(value = "/register",
            method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8")
    public ResponseResult saveUser(@RequestBody UserBean userBean){
        User user=userService.findUserByAccount(userBean.username);
        if(null==user){
            user=userBean.changeToUser();
            if(userService.saveUser(user)==1){
                return Response.makeRsp(200,"注册成功");
            }else {
                return Response.makeRsp(400,"注册失败");
            }
        }else {
            return Response.makeRsp(400,"用户已存在");
        }
    }

    @RequestMapping(value = "/getAllUser",method = RequestMethod.GET)
    public ResponseResult<List<User>> getAllUser(){
        return Response.makeOKRsp(userService.getAllUser());
    }

}
