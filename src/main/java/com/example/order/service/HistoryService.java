package com.example.order.service;

import com.example.order.entity.HistoryProduct;
import com.example.order.mapper.HistoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoryService {
    @Autowired
    HistoryMapper historyMapper;
    public Integer saveHistoty(HistoryProduct historyProduct){
        return historyMapper.saveHistoty(historyProduct);
    }
}
