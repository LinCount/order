package com.example.order.ResponseBean;

import com.example.order.entity.Product;

import java.math.BigDecimal;

public class ListProduct {
    public String id;
    public String name;
    public BigDecimal price;
    public Integer number;
    public String cailiao;
    public String img;
    public  ListProduct(Product product){
        this.id=product.getP_id();
        this.name=product.getFood();
        this.price=product.getA_price();
        this.number=product.getNumber();
        this.cailiao=product.getNutrition();
        this.img=product.getPicture();
    }
}
