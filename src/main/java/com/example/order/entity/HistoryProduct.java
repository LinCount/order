package com.example.order.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class HistoryProduct implements Serializable {
    private String h_id;
    private String o_id;
    private String p_id;
    private String shopName;
    private String productName;
    private Integer orderNum;
    private BigDecimal productmoney;

    public HistoryProduct(String p_id,String productName ,String shopName,Integer orderNum, BigDecimal productmoney) {
        this.p_id = p_id;
        this.productName=productName;
        this.shopName=shopName;
        this.orderNum = orderNum;
        this.productmoney = productmoney;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public HistoryProduct(String h_id) {
        this.h_id = h_id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getH_id() {
        return h_id;
    }

    public void setH_id(String h_id) {
        this.h_id = h_id;
    }

    public String getO_id() {
        return o_id;
    }

    public void setO_id(String o_id) {
        this.o_id = o_id;
    }

    public String getP_id() {
        return p_id;
    }

    public void setP_id(String p_id) {
        this.p_id = p_id;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public BigDecimal getProductmoney() {
        return productmoney;
    }

    public void setProductmoney(BigDecimal productmoney) {
        this.productmoney = productmoney;
    }
}
