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
    @RequestMapping(value = "/login",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResponseResult<Token> login(@RequestBody UserBean userBean){
        //检查必要字段格式
        //查询用户是否存在
        User user=userService.findUserByAccount(userBean.account);
        if(null!=user){
            if(userBean.account.equals(user.getAccount())&&userBean.password.equals(user.getPassword())){
                return Response.makeOKRsp(new Token().token=user.getToken());
            }else {{
                return Response.makeErrRsp("登录信息不正确");
            }}
        }else{
            return Response.makeErrRsp("用户不存在");
        }
    }
    @RequestMapping(value = "/getAllUser",method = RequestMethod.GET)
    public ResponseResult<List<User>> getAllUser(){
        return Response.makeOKRsp(userService.getAllUser());
    }
}
