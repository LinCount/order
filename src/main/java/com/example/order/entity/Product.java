package com.example.order.entity;

import java.io.Serializable;
import java.math.BigDecimal;
//菜品实体
public class Product implements Serializable {
    private String p_id;//菜品编号
    private String s_id;//餐馆编号
    private String food;//菜名
    private BigDecimal a_price;//原来价格
    private BigDecimal promotion;//优惠价格
    private BigDecimal discount;//折扣
    private String picture;//图片
    private String remark;//简介
    private String type;//菜品类型
    private String nutrition;//营养属性
    private String c_time;//创建时间
    private double grade;//评分

    public String getP_id() {
        return p_id;
    }

    public void setP_id(String p_id) {
        this.p_id = p_id;
    }

    public String getS_id() {
        return s_id;
    }

    public void setS_id(String s_id) {
        this.s_id = s_id;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public BigDecimal getA_price() {
        return a_price;
    }

    public void setA_price(BigDecimal a_price) {
        this.a_price = a_price;
    }

    public BigDecimal getPromotion() {
        return promotion;
    }

    public void setPromotion(BigDecimal promotion) {
        this.promotion = promotion;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNutrition() {
        return nutrition;
    }

    public void setNutrition(String nutrition) {
        this.nutrition = nutrition;
    }

    public String getC_time() {
        return c_time;
    }

    public void setC_time(String c_time) {
        this.c_time = c_time;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}
