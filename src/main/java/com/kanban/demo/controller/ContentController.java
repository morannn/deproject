package com.kanban.demo.controller;

import com.kanban.demo.entity.Msg;
import com.kanban.demo.entity.content;
import com.kanban.demo.entity.login;
import com.kanban.demo.service.ContentService;
import com.kanban.demo.service.LoginService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "任务内容相关接口")
@RestController
@RequestMapping("/content")

public class ContentController {

    @Autowired
    ContentService contentService;



    @ApiOperation(value = "id获取任务内容接口")

    @GetMapping("/getByid/{id}")

    public Msg getContentById(@PathVariable int id) {
        return contentService.getContentById(id);
    }



    @ApiOperation(value = "添加任务内容接口")

    @PostMapping("/addContent")

    public Msg addContent(@RequestBody content content) {
        return contentService.insertContent(content);
    }



    @ApiOperation(value = "更新任务内容接口")

    @PostMapping("/updateContent")

    public Msg updateContent(@RequestBody content content) {
        return contentService.updateContent(content.getId(),content.getMattercontent());
    }

}
