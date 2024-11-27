package com.kanban.demo.service;

import com.kanban.demo.entity.Msg;
import com.kanban.demo.entity.matter;
import com.kanban.demo.entity.user;
import com.kanban.demo.mapper.Usermapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    Usermapper usermapper;

    public Msg getDepartmentByUsername(String username){
        Msg msg=new Msg();

        String department=usermapper.getDepartmentByUsername(username);

        if(department.equals("")){
            msg.setMessage("获取失败！");
            msg.setResult(false);
        }else{
            msg.setData(department);
            msg.setResult(true);
            msg.setMessage("获取成功！");
        }
        return msg;
    }

    public Msg insertUser(String username,String department){
        Msg msg=new Msg();
        int num;
        if(department.equals("admin")){
            num=usermapper.insertUser(username,department,1);
        }else{
            num=usermapper.insertUser(username,department,0);
        }
        user user=usermapper.selectUserByName(username);
        if(num==0){
            msg.setMessage("注册失败！");
            msg.setResult(false);
        }else{
            msg.setData(user);
            msg.setResult(true);
            msg.setMessage("注册成功！");
        }
        return msg;
    }

    public Msg getUserByName(String name){
        Msg msg=new Msg();
        user user=usermapper.selectUserByName(name);
        if(user==null){
            msg.setMessage("查询失败！");
            msg.setResult(false);
        }else{
            msg.setData(user);
            msg.setResult(true);
            msg.setMessage("查询成功！");
        }
        return msg;
    }
}
