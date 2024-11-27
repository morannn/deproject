package com.kanban.demo.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kanban.demo.entity.Msg;
import com.kanban.demo.entity.matter;
import com.kanban.demo.mapper.Contentmapper;
import com.kanban.demo.mapper.Mattermapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MatterService {

    @Autowired
    Mattermapper mattermapper;

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
        System.out.println(department);
        System.out.println(status);
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
}
