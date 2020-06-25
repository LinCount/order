package com.example.order.mapper;

import com.example.order.entity.HistoryProduct;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface HistoryMapper {
    @Insert("insert into historyproduct (h_id,o_id,p_id,orderNum,productmoney)" +
            "values(#{h_id},#{o_id},#{p_id},#{orderNum},#{productmoney})")
    Integer saveHistoty(HistoryProduct historyProduct);
}
