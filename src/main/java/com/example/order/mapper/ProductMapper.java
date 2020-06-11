package com.example.order.mapper;

import com.example.order.entity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ProductMapper {
    @Select("select * from product where s_id =#{s_id}")
    List<Product> findProductByS_id(@Param("s_id")String s_id);
}
