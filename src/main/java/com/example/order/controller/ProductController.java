package com.example.order.controller;

import com.example.order.Api.Response;
import com.example.order.Api.ResponseResult;
import com.example.order.ResponseBean.ResponseProduct;
import com.example.order.entity.Product;
import com.example.order.entity.ShopProduct;
import com.example.order.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping(value = "/{s_id}")
    public ResponseResult<ShopProduct> product(@PathVariable(name = "s_id") String s_id) {
        int i = 1;
        String type;

            if (i <2) {
                type = "小吃";
                ShopProduct shopProduct= productService.findProductByS_id(s_id,type);
                return Response.makeRsp(200,"成功",shopProduct);
            } else {
                type = "饮料";
                ShopProduct shopProduct= productService.findProductByS_id(s_id,type);
                return Response.makeRsp(200,"成功",shopProduct);
            }

    }
    @RequestMapping(value = "/getProduct",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public ResponseResult<List<ResponseProduct>> getShopProduct(@RequestParam String id){
        List<ResponseProduct> list=new ArrayList<>();
        ResponseProduct product1=new ResponseProduct("热销");
        ResponseProduct product2=new ResponseProduct("优惠");
        ResponseProduct product3=new ResponseProduct("套餐");
        ResponseProduct product4=new ResponseProduct("小吃");
        ResponseProduct product5=new ResponseProduct("饮料");
        product1.setContent(productService.findProductByType(id,"热销"));
        product2.setContent(productService.findProductByType(id,"优惠"));
        product3.setContent(productService.findProductByType(id,"套餐"));
        product4.setContent(productService.findProductByType(id,"小吃"));
        product5.setContent(productService.findProductByType(id,"饮料"));
        list.add(product1);
        list.add(product2);
        list.add(product3);
        list.add(product4);
        list.add(product5);
        return Response.makeOKRsp(list);
    }
}
