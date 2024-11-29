package com.kanban.demo.controller;

import com.kanban.demo.entity.Msg;
import com.kanban.demo.entity.login;
import com.kanban.demo.service.LoginService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping("/login")

@Api(tags = "登录相关接口")

public class LoginController {

    @Autowired
    LoginService loginService;

    //查询所有
    @PostMapping("/loginBypsd")

    @ApiOperation(value = "登录接口")

    public Msg doLogin(@RequestBody login login) {
        return loginService.doLogin(login);
    }

    @PostMapping("/register")

    @ApiOperation(value = "注册接口")

    public Msg insertLogin(@RequestBody login login) {
        return loginService.insertLogin(login);
    }
}
