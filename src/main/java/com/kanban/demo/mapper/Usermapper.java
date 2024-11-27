package com.kanban.demo.mapper;

import com.kanban.demo.entity.user;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface Usermapper {
    @Select("select * from user where username=#{username}")
    user selectUserByName(@Param("username") String username);

    @Insert("insert into user(username,department,rankmun) value (#{username},#{department},#{rankmun})")
    user insertUser(@Param("username")String username,@Param("department")String department,@Param("rankmun")String rankmun);

    @Select("select ranknum from user where username = #{username}")
    user selectfinduranknum(@Param("username")String username);

<<<<<<< HEAD
    @Select("select department from user where username=#{username}")
    String getDepartmentByUsername(@Param("username")String username);
=======

>>>>>>> c24ce7f5d7166d86a3373657841fb9d2f934a080

}


