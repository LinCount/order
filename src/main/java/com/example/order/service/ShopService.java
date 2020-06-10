package com.example.order.service;

import com.example.order.entity.Shop;
import com.example.order.mapper.ShopMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopService {
    @Autowired
    ShopMapper shopMapper;
    public List<Shop> findAllSopByArea(String area){
        return shopMapper.findAllShopByArea(area);
    }

}
