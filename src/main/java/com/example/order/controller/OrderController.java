package com.example.order.controller;

import com.example.order.Api.Response;
import com.example.order.ResponseBean.EchartsData;
import com.example.order.ResponseBean.HistoryOrder;
import com.example.order.ResponseBean.ResponseProductList;
import com.example.order.entity.HistoryProduct;
import com.example.order.entity.Orders;
import com.example.order.Api.ResponseResult;
import com.example.order.mapper.HistoryMapper;
import com.example.order.requestBean.FoodNumber;
import com.example.order.service.HistoryService;
import com.example.order.service.OrderService;
import com.example.order.service.ProductService;
import com.example.order.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
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
    HistoryService historyService;
    @Autowired
    UserService userService;
    //购买
    @RequestMapping(value = "/orderCar",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public ResponseResult orderFood(@RequestBody List<FoodNumber> list){
        if(list==null){
            return Response.makeRsp(403,"购物车为空");
        }
        BigDecimal bigDecimal=new BigDecimal(0);
        Orders orders = new Orders(UUID.randomUUID().toString(),list.get(0).userid);//生成订单
        try {
            for (FoodNumber food : list) {
                //店铺商品数量减少
                Integer productNum = productService.findProductNumberById(food.item.id);
                if(null==productNum)
                    return Response.makeRsp(403, "菜品不存在");
                synchronized (productNum) {
                    if (productNum >= food.item.number) {
                        if(productService.updaureProductNumberById(food.item.id, productNum - food.number)==1){
                            //保存历史菜品信息
                            HistoryProduct historyProduct=new HistoryProduct(UUID.randomUUID().toString());
                            historyProduct.setO_id(orders.getO_id());
                            historyProduct.setP_id(food.item.id);
                            historyProduct.setShopName(food.shopname);
                            System.out.println(food.shopname);
                            historyProduct.setProductName(food.item.name);
                            historyProduct.setOrderNum(food.item.number);
                            historyProduct.setProductmoney(food.item.prcie.multiply(new BigDecimal(food.item.number)));
                            historyService.saveHistoty(historyProduct);
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
    //历史订单查询
    @RequestMapping(value = "/historyOrder",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    public ResponseResult<List<HistoryOrder>> showHistoryOrder(@RequestParam String userid){
        //获取全部订单号
        if(userid.equals(""))
            return Response.makeErrRsp("用户参数数错误");
        List<Orders> orderNum=orderService.getOrderIdByUid(userid);
        if(null==orderNum)
            return Response.makeOKRsp("该用户无历史订单");
        List<HistoryOrder> orderList=new ArrayList<>();
        for (Orders orders:orderNum) {
            HistoryOrder historyOrder=new HistoryOrder();
            historyOrder.orderId=orders.getO_id();
            historyOrder.product=historyService.getHistoryProductByOid(orders.getO_id());
            historyOrder.allmoney=orders.getO_money();
            if(historyOrder.product.size()>0)
                for(ResponseProductList productList:historyOrder.product){
                    if (!productList.equals("")){
                        historyOrder.shopName=productList.shopName;
                    }
            }
            orderList.add(historyOrder);
        }
        return  Response.makeOKRsp(orderList);
    }
    @RequestMapping(value = "/echartsData",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    public ResponseResult<List<EchartsData>> getEchartsData(@RequestParam String userid){
        if(userid==null){
            return Response.makeErrRsp("请输入正确的用户id");
        }else {
            if(userService.findUserById(userid)==null){
                return Response.makeErrRsp("用户不存在");
            }
        }
        List<EchartsData> echartsList=new ArrayList<>();
        echartsList.add(0,new EchartsData("汤/面",0));
        echartsList.add(1,new EchartsData("快餐",0));
        echartsList.add(2,new EchartsData("早餐",0));
        echartsList.add(3,new EchartsData("烧烤",0));
        echartsList.add(4,new EchartsData("小炒",0));
        //检查是否存在订单
        List<Orders> ordersList=orderService.getOrderIdByUid(userid);
        if(ordersList==null){
            return Response.makeOKRsp(echartsList);
        }
       for(int i=0;i<=4;i++){
           Integer value=productService.getNumberFromUid(userid,echartsList.get(i).getName());
           System.out.println(value);
           if(value>=0) {
               echartsList.get(i).setValue(value);
           }
       }
        return Response.makeOKRsp(echartsList);
    }

}
