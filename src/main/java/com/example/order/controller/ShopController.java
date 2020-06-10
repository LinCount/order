package com.example.order.controller;

import com.example.order.Api.Response;
import com.example.order.Api.ResponseResult;
import com.example.order.ResponseBean.ShowShop;
import com.example.order.entity.Shop;
import com.example.order.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value ="/shop" )
public class ShopController  {
    @Autowired
    ShopService shopService;
    @RequestMapping(value = "/getShop",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public ResponseResult getShopInfo(@RequestParam String area){
        List<Shop> shopList=shopService.findAllSopByArea(area);
        List<ShowShop> showList=new ArrayList<>();
        if(!shopList.isEmpty()){
            for (Shop shop:shopList) {
                ShowShop showShop=new ShowShop(shop);
                showShop.toString();
                showList.add(showShop);
            }
        }
        return Response.makeOKRsp(showList);
    }
}
