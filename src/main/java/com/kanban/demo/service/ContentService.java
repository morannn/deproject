package com.kanban.demo.service;

import com.kanban.demo.entity.Msg;
import com.kanban.demo.entity.content;
import com.kanban.demo.mapper.Contentmapper;
import com.kanban.demo.mapper.Loginmapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class ContentService {

    @Autowired
    Contentmapper contentmapper;

    public Msg getContentById(int id){
        Msg msg=new Msg();
        content content=contentmapper.selectContentById(id);
        msg.setResult(true);
        msg.setData(content);
        msg.setMessage("查询成功！");
        return msg;
    }
}
