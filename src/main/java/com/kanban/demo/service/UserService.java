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
