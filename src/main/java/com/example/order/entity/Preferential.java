package com.example.order.entity;

import java.io.Serializable;

public class Preferential implements Serializable {
    private String preId;//优惠id
    private String shopId;//店铺id
    private Float full;//满足金额
    private Float backUser;//减少金额

    public String getPreId() {
        return preId;
    }

    public void setPreId(String preId) {
        this.preId = preId;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public Float getFull() {
        return full;
    }

    public void setFull(Float full) {
        this.full = full;
    }

    public Float getBackUser() {
        return backUser;
    }

    public void setBackUser(Float backUser) {
        this.backUser = backUser;
    }
}
