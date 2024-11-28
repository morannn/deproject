package com.kanban.demo.controller;

import com.kanban.demo.entity.Msg;
import com.kanban.demo.entity.matter;
import com.kanban.demo.service.ContentService;
import com.kanban.demo.service.MatterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/matter")
@Api(tags = "任务相关接口")
public class MatterController {
    @Autowired
    MatterService matterService;

    @GetMapping("/task/{mattername}")
    @ApiOperation(value = "name获取任务接口")
    public Msg getMatterByName(@PathVariable String mattername) {
        return matterService.getMatterByName(mattername);
    }

    @GetMapping("/getById/{id}")
    @ApiOperation(value = "id获取任务接口")
    public Msg getMatterById(@PathVariable int id) {
        return matterService.getMatterById(id);
    }


    @GetMapping("/flow/all/{department}")
    @ApiOperation(value = "department获取任务接口")
    public Msg getMatterByDepartment(@PathVariable String department) {
        return matterService.getMatterByDepartment(department);
    }

    @GetMapping("/alldepartments")
    @ApiOperation(value = "获取所有部门接口")
    public Msg getAllDepartments() {
        return matterService.getAllDepartments();
    }

    @GetMapping("/allmatters")
    @ApiOperation(value = "获取所有任务接口")
    public Msg getAllMatters() {
        return matterService.getAllMatters();
    }

    @GetMapping("/flow/status/{department}/{status}")
    @ApiOperation(value = "department和status获取任务接口")
    public Msg getMatterByDepartmentandStatus(@PathVariable String department,@PathVariable String status) {
        return matterService.getMatterByDepartmentandstatus(department,status);
    }

    @PostMapping("/add")
    @ApiOperation(value = "添加任务接口")
    public Msg addMatter(@RequestBody matter matter) {
        return matterService.insert(matter);
    }

    @PostMapping("/update")
    @ApiOperation(value = "更新任务接口")
    public Msg updateMatter(@RequestBody matter matter) {
        return matterService.updateMatter(matter);
    }

    @GetMapping("/delete/{id}")
    @ApiOperation(value = "删除任务接口")
    public Msg deleteMatter(@PathVariable int id) {
        return matterService.deleteMatter(id);
    }

    @GetMapping("/updateStatus/{id}/{status}")
    @ApiOperation(value = "id和status更新任务接口")
    public Msg updateMatterStatus(@PathVariable int id,@PathVariable String status) {
        return matterService.updateMatterStatus(id,status);
    }

    @GetMapping("/getMatter/{id}")
    @ApiOperation(value = "id获取部门接口")
    public Msg getMatterByid(@PathVariable int id) {
        return matterService.getDepartmentByid(id);
    }

    @GetMapping("/getMatterByDepartmentAndUsername/{username}/{department}/{status}")
    @ApiOperation(value = "department和username和status获取任务接口")
    public Msg getMatterByid(@PathVariable String username,@PathVariable String department,@PathVariable String status) {
        return matterService.getMattersByDepartmentAndUsername(username,department,status);
    }

}
