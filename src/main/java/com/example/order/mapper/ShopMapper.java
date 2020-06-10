package com.example.order.mapper;

import com.example.order.entity.Shop;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
@Mapper
public interface ShopMapper {
    //商家浏览查询，缺少分页
    @Select("select * from shop where address=#{address}")
    @Results(
      {@Result(property = "s_id" ,column = "s_id"),
              @Result(property = "shopName" ,column = "shopName"),
              @Result(property = "shopPicture" ,column = "shopPicture"),
              @Result(property = "star" ,column = "star"),
              @Result(property = "saleInMoon" ,column = "saleInMoon"),
              @Result(property = "beginDelive" ,column = "beginDelive"),
              @Result(property = "preferSet",javaType = Set.class, column = "s_id",
                      many = @Many(select="com.example.order.mapper.PreferentialMapper.findPreferByShopId"))
    })
    List<Shop> findAllShopByArea(@Param("address")String area);
}
