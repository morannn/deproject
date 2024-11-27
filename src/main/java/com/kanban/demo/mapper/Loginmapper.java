package com.kanban.demo.mapper;

import com.kanban.demo.entity.login;
import com.kanban.demo.entity.user;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface Loginmapper {
    @Select("select * from login where username=#{username}")
    login selectLoginByName(@Param("username") String username);

    @Insert("insert into login(username,password) value (#{username},#{password})")
    login selectfindBy(@Param("username")String username,@Param("password")String password);

    @Select ("select password from login where username = #{username} and password=#{password}")
    login login(@Param("username")String username,@Param("password")String password);
}
