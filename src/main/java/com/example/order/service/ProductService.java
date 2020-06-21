package com.example.order.service;

import com.example.order.entity.Product;
import com.example.order.entity.ShopProduct;
import com.example.order.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductMapper productMapper;
    public ShopProduct findProductByS_id(String s_id,String type){
        ShopProduct shopProduct =new ShopProduct();
        List<Product> product =productMapper.findProductByS_id(s_id, type);
        shopProduct.setType(type);
        shopProduct.setListProduct(product);
        return shopProduct;
    }
    public List<Product> findProductByType(String id,String type){
        return productMapper.findProductByType(id,type);
    }
}
