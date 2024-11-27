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

<<<<<<< HEAD
    @GetMapping("/getMatterByUsername/{username}")
    public Msg getDepartmentByUsername(@PathVariable String username) {
        return userService.getDepartmentByUsername(username);
    }

=======
>>>>>>> c24ce7f5d7166d86a3373657841fb9d2f934a080
    @GetMapping("/getByName/{username}")
    public Msg getUserByName(@PathVariable String username) {
        return userService.getUserByName(username);
    }
}
