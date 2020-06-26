package com.example.order.service;

import com.example.order.entity.Orders;
import com.example.order.mapper.OrdersMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrdersMapper ordersMapper;
    public Integer saveOrder(Orders order){
        return ordersMapper.saveOrder(order);
    }
    public List<Orders> getOrderIdByUid(String userId){
        return ordersMapper.getOrderIdByUid(userId);
    }
}
