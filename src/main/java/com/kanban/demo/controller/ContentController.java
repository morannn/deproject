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
public class ContentController {

    @Autowired
    ContentService contentService;

    @GetMapping("/content/getByid/{id}")
    @ApiOperation(value = "id获取任务内容接口")
    public Msg getContentById(@PathVariable int id) {
        return contentService.getContentById(id);
    }

    @PostMapping("/content/addContent")
    @ApiOperation(value = "添加任务内容接口")
    public Msg addContent(@RequestBody content content) {
        return contentService.insertContent(content);
    }

    @PostMapping("/content/updateContent")
    @ApiOperation(value = "更新任务内容接口")
    public Msg updateContent(@RequestBody content content) {
        return contentService.updateContent(content.getId(),content.getMattercontent());
    }

}
