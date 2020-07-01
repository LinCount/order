package com.example.order.mapper;

import com.example.order.entity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ProductMapper {
    @Select("select * from product where s_id =#{s_id}")
    List<Product> findProductByS_id(@Param("s_id")String s_id);
    @Select("select * from product where s_id =#{s_id} and type=#{type}")
    List<Product> findProductByType(@Param("s_id")String s_id,@Param("type")String type);
    //查询菜品数量
    @Select("select number from product where p_id=#{p_id} limit 1")
    Integer findProductNumberById(@Param("p_id")String p_id);
    //改变菜品数量
    @Update("update product set number=#{number} where p_id=#{p_id}")
    Integer updaureProductNumberById(@Param("p_id")String p_id,@Param("number")Integer number);
    //根据用户id和菜品类型统计
    @Select("SELECT COUNT(*) FROM product p WHERE p_id IN" +
            "(SELECT p_id FROM historyproduct " +
            "WHERE  o_id IN (SELECT o_id FROM orders WHERE u_id=#{userId}))" +
            "AND p.`type`=#{type}" +
            "LIMIT 1")
    Integer getNumberFromUid(@Param("userId")String userId,@Param("type")String type);
}
