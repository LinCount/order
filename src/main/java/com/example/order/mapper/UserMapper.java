package com.example.order.mapper;

import com.example.order.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {
    @Select("select * from  user")
    List<User> getAllUser();
    @Select("select * from user where u_id = #{u_id}")
    User findUserById(@Param("u_id")String u_id);

}
