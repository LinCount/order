package com.example.order.mapper;

import com.example.order.entity.Orders;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface OrdersMapper {
    @Insert("insert into orders(o_id,u_id,d_id,o_time,s_time,s_status,is_send,o_status,p_status,o_money,s_address,remark) " +
            "values(#{o_id},#{u_id},#{d_id},#{o_time},#{s_time},#{s_status},#{is_send},#{o_status},#{p_status},#{o_money},#{s_address},#{remark})")
    Integer saveOrder(Orders order);
    //查询历史订单号
    @Select("select o_id,o_money from orders where u_id=#{u_id}")
    List<Orders> getOrderIdByUid(@Param("u_id") String u_id);
}
