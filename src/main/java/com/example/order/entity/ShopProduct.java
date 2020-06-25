package com.example.order.entity;


import java.util.List;

public class ShopProduct {
    private String type;

    private List<Product> ListProduct;


    public List<Product> getListProduct() {
        return ListProduct;
    }

    public void setListProduct(List<Product> listProduct) {
        ListProduct = listProduct;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
