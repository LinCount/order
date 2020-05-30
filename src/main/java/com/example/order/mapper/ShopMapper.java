package com.example.order.mapper;

import com.example.order.entity.Shop;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ShopMapper {
    @Select("select * from shop")
    List<Shop> findAllShop();
}
