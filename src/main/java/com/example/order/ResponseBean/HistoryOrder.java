package com.example.order.ResponseBean;

import java.math.BigDecimal;
import java.util.List;

public class HistoryOrder {
    public String orderId;//订单id
    public BigDecimal allmoney;
    public List<ResponseProductList> product;//菜品
}


