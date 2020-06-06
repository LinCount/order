package com.example.order.requestBean;

import com.example.order.entity.User;

import java.util.Date;
import java.util.UUID;

public class UserBean {
    public String UserId;//用户编号
    public String name;//昵称
    public String username;//账户
    public String pwd;//密码
    public String phone;//电话
    public String sex;//性别
    public Date birthday;//生日
    public String brief;//简介
    public Date time;//创建时间
    public String address;//地址
    public User changeToUser(){
        User user=new User();
        user.setU_id(UUID.randomUUID().toString());
        user.setAccount(this.username);
        user.setPassword(this.pwd);
        user.setC_time(new Date(System.currentTimeMillis()));
        user.setToken(UUID.randomUUID().toString());
        return user;
    }
}
