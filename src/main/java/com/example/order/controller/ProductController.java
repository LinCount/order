package com.example.order.controller;

import com.example.order.Api.Response;
import com.example.order.Api.ResponseResult;
import com.example.order.entity.Product;
import com.example.order.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping(value = "/{s_id}")
    public ResponseResult<List<Product>> product(@PathVariable(name = "s_id") String s_id){
        List<Product> product = productService.findProductAll(s_id);
        return Response.makeRsp(200,"菜品查询成功",product);
    }
}
