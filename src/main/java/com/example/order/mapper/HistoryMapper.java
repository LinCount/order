package com.example.order.mapper;

import com.example.order.entity.HistoryProduct;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface HistoryMapper {
    @Insert("insert into historyproduct (h_id,productname,o_id,p_id,shopname,orderNum,productmoney)" +
            "values(#{h_id},#{productName},#{o_id},#{p_id},#{shopName},#{orderNum},#{productmoney})")
    Integer saveHistoty(HistoryProduct historyProduct);
    @Select("select p_id,productName,shopName,orderNum,productmoney from historyproduct where o_id=#{o_id}")
    List<HistoryProduct> getHistoryProductByOid(@Param("o_id")String o_id);
}
