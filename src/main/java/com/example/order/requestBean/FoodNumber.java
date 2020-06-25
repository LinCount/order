package com.example.order.requestBean;


public class FoodNumber {
    public String shopid;
    public String shopname;
    public Integer number;
    public FoodItem item;

    @Override
    public String toString() {
        return "FoodNumber{" +
                "shopid='" + shopid + '\'' +
                ", shopname='" + shopname + '\'' +
                ", number=" + number +
                ", item=" + item +
                '}';
    }
}
