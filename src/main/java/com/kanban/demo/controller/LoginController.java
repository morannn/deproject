package com.kanban.demo.controller;

import com.kanban.demo.entity.Msg;
import com.kanban.demo.entity.login;
import com.kanban.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    LoginService loginService;

    //查询所有
    @PostMapping("/loginBypsd")
    public Msg doLogin(@RequestBody login login) {
        return loginService.doLogin(login);
    }
}
