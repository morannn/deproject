package com.kanban.demo.mapper;

import com.kanban.demo.entity.content;
import com.kanban.demo.entity.login;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface Contentmapper {

    @Select("select * from content where id=#{id}")
    content selectContentById(@Param("id") int id);

    @Insert("insert into content(id,mattercontent) value (#{id},#{mattercontent})")
    int insertContent(@Param("id")int id,@Param("mattercontent")String mattercontent);
}
