package com.example.order.entity;

import java.io.Serializable;

//系统管理员实体
public class System implements Serializable {
    private String sy_id;//系统管理员编号
    private String password;//密码
    private String role;//权限

    public String getSy_id() {
        return sy_id;
    }

    public void setSy_id(String sy_id) {
        this.sy_id = sy_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
