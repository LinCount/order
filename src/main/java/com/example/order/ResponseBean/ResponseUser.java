package com.example.order.ResponseBean;/*
 *@Author LinCount
 *@Data 2020/6/6 12:49
 *@Vesion 1.0
 */

import com.example.order.entity.User;

import java.util.Date;

public class ResponseUser {
    public String userId;//用户编号
    public String name;//昵称
    public String username;//账户
    public String phone;//电话
    public String sex;//性别
    public Date birthday;//生日
    public String brief;//简介
    public String address;//地址
    public void changeFromUser(User user){
        this.userId=user.getU_id();
        this.name=user.getName();
        this.username=user.getAccount();
        this.phone=user.getPhone();
        this.sex=user.getSex();
        this.birthday=user.getBirthday();
        this.brief=user.getBrief();
        this.address=user.getAddress();
    }
}
