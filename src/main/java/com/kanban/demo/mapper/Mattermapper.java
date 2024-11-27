package com.kanban.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kanban.demo.entity.login;
import com.kanban.demo.entity.matter;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;
import java.util.Date;

@Mapper
public interface Mattermapper extends BaseMapper {
    @Select("select * from matter where id=#{id}")
    matter selectMatterById(@Param("id") int id);

    @Select("select * from matter where mattername=#{mattername}")
    matter selectMatterByName(@Param("mattername") String mattername);

    @Select("SELECT *,\n" +
            "       CASE matterstatus\n" +
            "         WHEN 'nob' THEN 1\n" +
            "         WHEN 'ing' THEN 2\n" +
            "         WHEN 'end' THEN 3\n" +
            "         ELSE 4\n" +
            "       END AS status_order\n" +
            "FROM matter\n" +
            "ORDER BY status_order ASC;\n ")
    ArrayList<matter> selectMatterByDepartment(@Param("department") String department);

    @Select("select department from matter group by department")
    ArrayList<String> selectAllDepartments();

    @Select("select * from matter")
    ArrayList<matter> selectAllMatters();

    @Select("select * from matter where department=#{department} and matterstatus=#{matterstatus}")
    ArrayList<matter> selectMatterByDepartmentandstatus(@Param("department") String department,@Param("matterstatus") String matterstatus);

    @Insert("insert into matter value (#{id},#{mattername}),#{matterstatus},#{begintime}),#{yujitime},#{endtime},#{username},#{department})")
    int insertMatter(@Param("id")int id,@Param("mattername")String mattername,                                    @Param("matterstatus")String matterstatus,@Param("begintime") Date begintime,         @Param("yujitime")Date yujitime,@Param("endtime") Date endtime,
                        @Param("username")String username,@Param("department") String department);
}
