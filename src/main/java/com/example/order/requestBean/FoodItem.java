package com.example.order.requestBean;
import java.math.BigDecimal;

public class FoodItem {//id、材料、图片、菜名、库存数、菜价格
    public String id;
    public String cailiao;
    public String img;
    public String name;
    public Integer number;
    public BigDecimal prcie;

    @Override
    public String toString() {
        return "FoodItem{" +
                "id='" + id + '\'' +
                ", cailiao='" + cailiao + '\'' +
                ", img='" + img + '\'' +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", prcie=" + prcie +
                '}';
    }
}
