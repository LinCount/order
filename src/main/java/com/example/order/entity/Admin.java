package com.example.order.entity;

import java.io.Serializable;

//餐馆管理员
public class Admin implements Serializable {
    private String a_id;//管理员账户
    private String passord;//密码
    private String role;;//权限
    private String phone;//联系电话

    public String getA_id() {
        return a_id;
    }

    public void setA_id(String a_id) {
        this.a_id = a_id;
    }

    public String getPassord() {
        return passord;
    }

    public void setPassord(String passord) {
        this.passord = passord;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
