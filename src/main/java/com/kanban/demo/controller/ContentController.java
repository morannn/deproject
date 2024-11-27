package com.kanban.demo.controller;

import com.kanban.demo.entity.Msg;
import com.kanban.demo.entity.login;
import com.kanban.demo.service.ContentService;
import com.kanban.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/content")
public class ContentController {

    @Autowired
    ContentService contentService;

    @GetMapping("/getByid/{id}")
    public Msg getContentById(@PathVariable int id) {
        return contentService.getContentById(id);
    }



}
