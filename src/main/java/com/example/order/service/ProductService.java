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
    public List<Product> findProductByType(String id,String type){
        return productMapper.findProductByType(id,type);
    }
    public Integer findProductNumberById(String p_id){
        return productMapper.findProductNumberById(p_id);
    }
    public Integer updaureProductNumberById(String p_id,Integer number){
        return productMapper.updaureProductNumberById(p_id,number);
    }
}
