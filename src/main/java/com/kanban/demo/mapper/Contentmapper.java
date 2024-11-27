package com.kanban.demo.mapper;

import com.kanban.demo.entity.content;
import com.kanban.demo.entity.login;
import org.apache.ibatis.annotations.*;

@Mapper
public interface Contentmapper {

    @Select("select * from content where id=#{id}")
    content selectContentById(@Param("id") int id);

    @Update("update content set mattercontent=#{content} where id=#{id}")
    int updateContent(@Param("id") int id,@Param("content") String content);

    @Insert("insert into content(id,mattercontent) value (#{id},#{mattercontent})")
    int insertContent(@Param("id")int id,@Param("mattercontent")String mattercontent);
}
