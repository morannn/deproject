package com.kanban.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kanban.demo.entity.login;
import com.kanban.demo.entity.matter;
<<<<<<< HEAD
import org.apache.ibatis.annotations.*;
=======
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
>>>>>>> c24ce7f5d7166d86a3373657841fb9d2f934a080

import java.util.ArrayList;
import java.util.Date;

@Mapper
public interface Mattermapper extends BaseMapper {
<<<<<<< HEAD

    @Delete("delete from matter where id=#{id}")
    int deleteMatter(@Param("id") int id);

=======
>>>>>>> c24ce7f5d7166d86a3373657841fb9d2f934a080
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

<<<<<<< HEAD
    @Select("update matter set mattername=#{mattername} ,matterstatus=#{matterstatus} ,begintime=#{begintime} ,yujitime=#{yujitime} , endtime=#{endtime} , username=#{username} , department=#{department} where id=#{id}")
    void updateMatter(@Param("mattername")String mattername, @Param("matterstatus")String matterstatus,@Param("begintime") Date begintime,@Param("yujitime")Date yujitime,@Param("endtime") Date endtime,
                     @Param("username")String username,@Param("department") String department,@Param("id")int id);

    @Update("update matter set matterstatus =#{status} where id=#{id}")
    int updateMatterStatus(@Param("id")int id,@Param("status")String status);

    @Select("select * from matter where department=#{department} and matterstatus=#{matterstatus}")
    ArrayList<matter> selectMatterByDepartmentandstatus(@Param("department") String department,@Param("matterstatus") String matterstatus);

    @Insert("insert into matter (mattername,matterstatus,begintime,yujitime,endtime,username,department) value (#{mattername},#{matterstatus},#{begintime},#{yujitime},#{endtime},#{username},#{department})")
    int insertSelective (@Param("mattername")String mattername, @Param("matterstatus")String matterstatus,@Param("begintime") Date begintime,@Param("yujitime")Date yujitime,@Param("endtime") Date endtime,
                        @Param("username")String username,@Param("department") String department);

    @Select("select department from matter where id=#{id}")
    String getDepartmentByid(@Param("id")int id);

    @Select("select * from matter where username=#{username} and department=#{department} and matterstatus=#{status}")
    ArrayList<matter> getMattersByDepartmentAndUsername(@Param("username")String username,@Param("department")String department,@Param("status")String status);

=======
    @Select("select * from matter where department=#{department} and matterstatus=#{matterstatus}")
    ArrayList<matter> selectMatterByDepartmentandstatus(@Param("department") String department,@Param("matterstatus") String matterstatus);

    @Insert("insert into matter value (#{id},#{mattername}),#{matterstatus},#{begintime}),#{yujitime},#{endtime},#{username},#{department})")
    int insertMatter(@Param("id")int id,@Param("mattername")String mattername,                                    @Param("matterstatus")String matterstatus,@Param("begintime") Date begintime,         @Param("yujitime")Date yujitime,@Param("endtime") Date endtime,
                        @Param("username")String username,@Param("department") String department);
>>>>>>> c24ce7f5d7166d86a3373657841fb9d2f934a080
}
