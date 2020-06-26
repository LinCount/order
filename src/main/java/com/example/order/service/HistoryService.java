package com.example.order.service;

import com.example.order.ResponseBean.ResponseProductList;
import com.example.order.entity.HistoryProduct;
import com.example.order.mapper.HistoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HistoryService {
    @Autowired
    HistoryMapper historyMapper;
    public Integer saveHistoty(HistoryProduct historyProduct){
        return historyMapper.saveHistoty(historyProduct);
    }
    public List<ResponseProductList> getHistoryProductByOid(String oid){
        List<ResponseProductList> list=new ArrayList<>();
        List<HistoryProduct> history=historyMapper.getHistoryProductByOid(oid);
        if(history==null)
            return null;
        for (HistoryProduct product:history) {
            ResponseProductList p=new ResponseProductList();
            p.pid=product.getP_id();
            p.number=product.getOrderNum();
            p.calMoney=product.getProductmoney();
            p.productName=product.getProductName();
            list.add(p);
        }
        return list;
    }
}
