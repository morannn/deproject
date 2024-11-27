package com.kanban.demo.service;

import com.kanban.demo.entity.Msg;
import com.kanban.demo.entity.login;
import com.kanban.demo.mapper.Loginmapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    Loginmapper loginmapper;

    public Msg doLogin(login login){
        Msg msg = new Msg();
        login userExist = loginmapper.selectLoginByName(login.getUsername());
        if (userExist==null){
            msg.setResult(false);
            msg.setMessage("用户名不存在");
            msg.setData(null);
        }else {
            if (userExist.getPassword().equals(login.getPassword())){
                msg.setResult(true);//成功
                msg.setMessage("登录成功");
                userExist.setPassword("******");//脱敏
                msg.setData(userExist);
            }else {
                msg.setResult(false);//失败
                msg.setMessage("登录失败，密码错误！");
                msg.setData(null);
            }
        }
        return msg;
    }
}
