package com.kanban.demo.controller;

import com.kanban.demo.entity.Msg;
import com.kanban.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Api(tags = "用户相关接口")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/getMatterByUsername/{username}")
    @ApiOperation(value = "username获取部门接口")
    public Msg getDepartmentByUsername(@PathVariable String username) {
        return userService.getDepartmentByUsername(username);
    }

    @GetMapping("/register/{username}/{department}")
    @ApiOperation(value = "新增用户接口")
    public Msg insertUser(@PathVariable String username,@PathVariable String department) {
        return userService.insertUser(username,department);
    }

    @GetMapping("/getByName/{username}")
    @ApiOperation(value = "name获取用户接口")
    public Msg getUserByName(@PathVariable String username) {
        return userService.getUserByName(username);
    }
}
