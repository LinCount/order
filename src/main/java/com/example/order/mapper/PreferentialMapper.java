package com.example.order.mapper;

import com.example.order.entity.Preferential;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface PreferentialMapper {
    @Select("select * from preferential where shopId=#{shopId}")
    List<Preferential> findPreferByShopId( @Param("shopId") String shopId);
}
