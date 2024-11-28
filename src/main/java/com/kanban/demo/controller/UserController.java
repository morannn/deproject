package com.kanban.demo.controller;

import com.kanban.demo.entity.Msg;
import com.kanban.demo.service.UserService;
<<<<<<< HEAD
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
=======
>>>>>>> b5dc19de15dcf86a592376c6ba27475bc7288e1a
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
<<<<<<< HEAD
@Api(tags = "用户相关接口")
=======
>>>>>>> b5dc19de15dcf86a592376c6ba27475bc7288e1a
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/getMatterByUsername/{username}")
<<<<<<< HEAD
    @ApiOperation(value = "username获取部门接口")
=======
>>>>>>> b5dc19de15dcf86a592376c6ba27475bc7288e1a
    public Msg getDepartmentByUsername(@PathVariable String username) {
        return userService.getDepartmentByUsername(username);
    }

    @GetMapping("/register/{username}/{department}")
<<<<<<< HEAD
    @ApiOperation(value = "新增用户接口")
=======
>>>>>>> b5dc19de15dcf86a592376c6ba27475bc7288e1a
    public Msg insertUser(@PathVariable String username,@PathVariable String department) {
        return userService.insertUser(username,department);
    }

    @GetMapping("/getByName/{username}")
<<<<<<< HEAD
    @ApiOperation(value = "name获取用户接口")
=======
>>>>>>> b5dc19de15dcf86a592376c6ba27475bc7288e1a
    public Msg getUserByName(@PathVariable String username) {
        return userService.getUserByName(username);
    }
}
