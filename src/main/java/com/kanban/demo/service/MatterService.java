package com.kanban.demo.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kanban.demo.entity.Msg;
import com.kanban.demo.entity.matter;
import com.kanban.demo.mapper.Contentmapper;
import com.kanban.demo.mapper.Mattermapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MatterService {

    @Autowired
    Mattermapper mattermapper;

    @Autowired
    Contentmapper contentmapper;

    public Msg getMatterByName(String name){
        Msg msg=new Msg();
        matter matter=mattermapper.selectMatterByName(name);
        if(matter==null){
            msg.setMessage("查询失败！");
            msg.setResult(false);
        }else{
            msg.setData(matter);
            msg.setResult(true);
            msg.setMessage("查询成功！");
        }
        return msg;
    }

    public Msg insert(matter matter){
        Msg msg=new Msg();
        int id=mattermapper.insertSelective(matter);
        if(id==0){
            msg.setMessage("新增失败！");
            msg.setResult(false);
        }else{
            msg.setData(matter);
            msg.setResult(true);
            msg.setMessage("新增成功！");
        }

        return msg;
    }

    public Msg getMatterById(int id){
        Msg msg=new Msg();
        matter matter=mattermapper.selectMatterById(id);
        if(matter==null){
            msg.setMessage("查询失败！");
            msg.setResult(false);
        }else{
            msg.setData(matter);
            msg.setResult(true);
            msg.setMessage("查询成功！");
        }
        return msg;
    }

    public Msg getMatterByDepartment(String department){
        Msg msg=new Msg();
        ArrayList<matter> matters=new ArrayList<>();
        matters=mattermapper.selectMatterByDepartment(department);
        if(matters.size()==0){
            msg.setMessage("查询失败！");
            msg.setResult(false);
        }else{
            msg.setData(matters);
            msg.setResult(true);
            msg.setMessage("查询成功！");
        }
        return msg;
    }

    public Msg getMatterByDepartmentandstatus(String department,String status){
        Msg msg=new Msg();
        ArrayList<matter> matters=new ArrayList<>();
        matters=mattermapper.selectMatterByDepartmentandstatus(department,status);

        if(matters.size()==0){
            msg.setMessage("查询失败！");
            msg.setResult(false);
        }else{
            msg.setData(matters);
            msg.setResult(true);
            msg.setMessage("查询成功！");
        }
        return msg;
    }

    public Msg getAllDepartments(){
        Msg msg=new Msg();
        ArrayList<String> departments=new ArrayList<>();
        departments=mattermapper.selectAllDepartments();
        if(departments.size()==0){
            msg.setMessage("查询失败！");
            msg.setResult(false);
        }else{
            msg.setData(departments);
            msg.setResult(true);
            msg.setMessage("查询成功！");
        }
        return msg;
    }

    public Msg getAllMatters(){
        Msg msg=new Msg();

        ArrayList<matter> matters=new ArrayList<>();
        matters=mattermapper.selectAllMatters();
        if(matters.size()==0){
            msg.setMessage("查询失败！");
            msg.setResult(false);
        }else{
            msg.setData(matters);
            msg.setResult(true);
            msg.setMessage("查询成功！");
        }
        return msg;
    }

    public Msg getMattersByDepartmentAndUsername(String username,String department,String status){
        Msg msg=new Msg();

        ArrayList<matter> matters=new ArrayList<>();
        matters=mattermapper.getMattersByDepartmentAndUsername(username,department,status);

        if(matters.size()==0){
            msg.setMessage("查询失败！");
            msg.setResult(false);
        }else{
            msg.setData(matters);
            msg.setResult(true);
            msg.setMessage("查询成功！");
        }
        return msg;
    }

    public Msg deleteMatter(int id){
        Msg msg=new Msg();

        matter matter=new matter();
        matter=(matter)(getMatterById(id).getData());
        int num=mattermapper.deleteMatter(id);
        if(num==0){
            msg.setMessage("删除失败！");
            msg.setResult(false);
        }else{
            msg.setData(matter);
            msg.setResult(true);
            msg.setMessage("删除成功！");
        }
        return msg;
    }

    public Msg updateMatter(matter matter){
        Msg msg=new Msg();
        int id=matter.getId();

        String mattername=matter.getMattername();
        String matterstatus=matter.getMatterstatus();
        Date begintime=matter.getBegintime();
        Date yujitime=matter.getYujitime();

        String username=matter.getUsername();
        String department=matter.getDepartment();

        mattermapper.updateMatter(mattername,matterstatus,begintime,yujitime,username,department,id);
        matter matter1=mattermapper.selectMatterById(id);
        if(matter1==null){
            msg.setMessage("修改失败！");
            msg.setResult(false);
        }else{
            msg.setData(matter1);
            msg.setResult(true);
            msg.setMessage("修改成功！");
        }

        return msg;
    }

    public Msg getDepartmentByid(int id){
        Msg msg=new Msg();

        String department=mattermapper.getDepartmentByid(id);

        if(department==""){
            msg.setMessage("删除失败！");
            msg.setResult(false);
        }else{
            msg.setData(department);
            msg.setResult(true);
            msg.setMessage("删除成功！");
        }
        return msg;
    }

    public Msg updateMatterStatus(int id,String status){
        Msg msg=new Msg();

        int num=mattermapper.updateMatterStatus(id,status);

        if(num==0){
            msg.setMessage("删除失败！");
            msg.setResult(false);
        }else{
            msg.setData(num);
            msg.setResult(true);
            msg.setMessage("删除成功！");
        }
        return msg;
    }


}
