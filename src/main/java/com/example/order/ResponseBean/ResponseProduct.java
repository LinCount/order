package com.example.order.ResponseBean;

import com.example.order.entity.Product;

import java.util.ArrayList;
import java.util.List;


public class ResponseProduct {
    public String type;
    public List<ListProduct> content=new ArrayList<>();

    public ResponseProduct(String type) {
        this.type = type;
    }

    public void setContent(List<Product> listProduct){
        if(null!=listProduct) {
            for (Product product : listProduct) {
                ListProduct listProduct1=new ListProduct(product);
                this.content.add(listProduct1);
            }
        }else {
            this.content=null;
        }
    }
}
