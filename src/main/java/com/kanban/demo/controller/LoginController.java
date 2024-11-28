package com.kanban.demo.controller;

import com.kanban.demo.entity.Msg;
import com.kanban.demo.entity.login;
import com.kanban.demo.service.LoginService;
<<<<<<< HEAD
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
=======
>>>>>>> b5dc19de15dcf86a592376c6ba27475bc7288e1a
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping("/login")
<<<<<<< HEAD
@Api(tags = "登录相关接口")
=======
>>>>>>> b5dc19de15dcf86a592376c6ba27475bc7288e1a
public class LoginController {

    @Autowired
    LoginService loginService;

    //查询所有
    @PostMapping("/loginBypsd")
<<<<<<< HEAD
    @ApiOperation(value = "登录接口")
=======
>>>>>>> b5dc19de15dcf86a592376c6ba27475bc7288e1a
    public Msg doLogin(@RequestBody login login) {
        return loginService.doLogin(login);
    }

    @PostMapping("/register")
<<<<<<< HEAD
    @ApiOperation(value = "注册接口")
=======
>>>>>>> b5dc19de15dcf86a592376c6ba27475bc7288e1a
    public Msg insertLogin(@RequestBody login login) {
        return loginService.insertLogin(login);
    }
}
