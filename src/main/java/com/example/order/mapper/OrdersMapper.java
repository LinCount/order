package com.example.order.mapper;

import com.example.order.entity.Orders;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface OrdersMapper {
    @Insert("insert into orders(o_id,u_id,d_id,o_time,s_time,s_status,is_send,o_status,p_status,o_money,s_address,remark) " +
            "values(#{o_id},#{u_id},#{d_id},#{o_time},#{s_time},#{s_status},#{is_send},#{o_status},#{p_status},#{o_money},#{s_address},#{remark})")
    Integer saveOrder(Orders order);
}
