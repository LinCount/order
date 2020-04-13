package com.example.order.entity;

import java.io.Serializable;

//送餐人员实体
public class Delivers implements Serializable {
    private String d_id;//人员编号
    private String phone;//电话
    private String name;//姓名
    private String f_cord;//身份证正面地址
    private String b_card;//身份证反面地址
    private Double grade;//评分
    private String p_fine;//健康证地址

    public String getD_id() {
        return d_id;
    }

    public void setD_id(String d_id) {
        this.d_id = d_id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getF_cord() {
        return f_cord;
    }

    public void setF_cord(String f_cord) {
        this.f_cord = f_cord;
    }

    public String getB_card() {
        return b_card;
    }

    public void setB_card(String b_card) {
        this.b_card = b_card;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public String getP_fine() {
        return p_fine;
    }

    public void setP_fine(String p_fine) {
        this.p_fine = p_fine;
    }
}
