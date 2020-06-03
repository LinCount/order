package com.example.order.mapper;

import com.example.order.entity.User;
import org.apache.ibatis.annotations.Insert;
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
    //根据uid查询用户
    @Select("select u_id,name,account,password,phone,sex,birthday,brief,c_time,address,token from user where u_id = #{u_id}")
    User findUserById(@Param("u_id")String u_id);
    //根据account查询用户
    @Select("select u_id,account,password,token from user where account = #{account}")
    User findUserByAcount(@Param("account")String account);
    //插入一条数据
    @Insert("insert into user(u_id,name,account,password,phone,sex,birthday,brief,c_time,address,token) " +
            "values(#{u_id},#{name},#{account},#{password},#{phone}#{sex},#{birthday},#{brief},#{c_time,jdbcType=TIMESTAMP},#{address},#{token})")
    Integer saveUser(User user);
}
