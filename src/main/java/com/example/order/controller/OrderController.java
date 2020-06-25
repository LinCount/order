package com.example.order.controller;

import com.example.order.Api.Response;
import com.example.order.entity.HistoryProduct;
import com.example.order.entity.Orders;
import com.example.order.Api.ResponseResult;
import com.example.order.mapper.HistoryMapper;
import com.example.order.requestBean.FoodNumber;
import com.example.order.service.OrderService;
import com.example.order.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@RestController
@RequestMapping(value ="/order" )
public class OrderController {
    @Autowired
    ProductService productService;
    @Autowired
    OrderService orderService;
    @Autowired
    HistoryMapper historyMapper;
    //购买
    @RequestMapping(value = "/orderCar",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public ResponseResult orderFood(@RequestBody List<FoodNumber> list){
        if(list==null){
            return Response.makeRsp(403,"购物车为空");
        }
        BigDecimal bigDecimal=new BigDecimal(0);
        Orders orders = new Orders(UUID.randomUUID().toString(),"1121");//生成订单
        try {
            for (FoodNumber food : list) {
                //店铺商品数量减少
                Integer productNum = productService.findProductNumberById(food.item.id);
                if(null==productNum)
                    return Response.makeRsp(403, "菜品不存在");
                System.out.println(productNum);
                System.out.println(food.item.number);
                synchronized (productNum) {
                    if (productNum >= food.item.number) {
                        if(productService.updaureProductNumberById(food.item.id, productNum - food.number)==1){
                            //保存历史菜品信息
                            HistoryProduct historyProduct=new HistoryProduct(UUID.randomUUID().toString());
                            historyProduct.setO_id(orders.getO_id());
                            historyProduct.setP_id(food.item.id);
                            historyProduct.setOrderNum(food.item.number);
                            historyProduct.setProductmoney(food.item.prcie.multiply(new BigDecimal(food.item.number)));
                            historyMapper.saveHistoty(historyProduct);
                        }
                    } else {
                        return Response.makeRsp(403, "菜品数量不足");
                    }
                    bigDecimal = bigDecimal.add(food.item.prcie);
                }
            }
            //保存订单
            orders.setO_money(bigDecimal);
            orderService.saveOrder(orders);
        }catch (Exception e){
            e.printStackTrace();
            return Response.makeRsp(403, "服务器出错");
        }
        return Response.makeRsp(200,"购买成功");
    }
}
