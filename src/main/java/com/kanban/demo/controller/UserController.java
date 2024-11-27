package com.kanban.demo.controller;

import com.kanban.demo.entity.Msg;
import com.kanban.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/getMatterByUsername/{username}")
    public Msg getDepartmentByUsername(@PathVariable String username) {
        return userService.getDepartmentByUsername(username);
    }

    @GetMapping("/register/{username}/{department}")
    public Msg insertUser(@PathVariable String username,@PathVariable String department) {
        return userService.insertUser(username,department);
    }

    @GetMapping("/getByName/{username}")
    public Msg getUserByName(@PathVariable String username) {
        return userService.getUserByName(username);
    }
}
