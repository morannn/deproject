package com.kanban.demo.controller;

import com.kanban.demo.entity.Msg;
import com.kanban.demo.entity.matter;
import com.kanban.demo.service.ContentService;
import com.kanban.demo.service.MatterService;
<<<<<<< HEAD
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
=======
>>>>>>> b5dc19de15dcf86a592376c6ba27475bc7288e1a
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/matter")
<<<<<<< HEAD
@Api(tags = "任务相关接口")
=======
>>>>>>> b5dc19de15dcf86a592376c6ba27475bc7288e1a
public class MatterController {
    @Autowired
    MatterService matterService;

    @GetMapping("/task/{mattername}")
<<<<<<< HEAD
    @ApiOperation(value = "name获取任务接口")
=======
>>>>>>> b5dc19de15dcf86a592376c6ba27475bc7288e1a
    public Msg getMatterByName(@PathVariable String mattername) {
        return matterService.getMatterByName(mattername);
    }

    @GetMapping("/getById/{id}")
<<<<<<< HEAD
    @ApiOperation(value = "id获取任务接口")
=======
>>>>>>> b5dc19de15dcf86a592376c6ba27475bc7288e1a
    public Msg getMatterById(@PathVariable int id) {
        return matterService.getMatterById(id);
    }


    @GetMapping("/flow/all/{department}")
<<<<<<< HEAD
    @ApiOperation(value = "department获取任务接口")
=======
>>>>>>> b5dc19de15dcf86a592376c6ba27475bc7288e1a
    public Msg getMatterByDepartment(@PathVariable String department) {
        return matterService.getMatterByDepartment(department);
    }

    @GetMapping("/alldepartments")
<<<<<<< HEAD
    @ApiOperation(value = "获取所有部门接口")
=======
>>>>>>> b5dc19de15dcf86a592376c6ba27475bc7288e1a
    public Msg getAllDepartments() {
        return matterService.getAllDepartments();
    }

    @GetMapping("/allmatters")
<<<<<<< HEAD
    @ApiOperation(value = "获取所有任务接口")
=======
>>>>>>> b5dc19de15dcf86a592376c6ba27475bc7288e1a
    public Msg getAllMatters() {
        return matterService.getAllMatters();
    }

    @GetMapping("/flow/status/{department}/{status}")
<<<<<<< HEAD
    @ApiOperation(value = "department和status获取任务接口")
=======
>>>>>>> b5dc19de15dcf86a592376c6ba27475bc7288e1a
    public Msg getMatterByDepartmentandStatus(@PathVariable String department,@PathVariable String status) {
        return matterService.getMatterByDepartmentandstatus(department,status);
    }

    @PostMapping("/add")
<<<<<<< HEAD
    @ApiOperation(value = "添加任务接口")
=======
>>>>>>> b5dc19de15dcf86a592376c6ba27475bc7288e1a
    public Msg addMatter(@RequestBody matter matter) {
        return matterService.insert(matter);
    }

    @PostMapping("/update")
<<<<<<< HEAD
    @ApiOperation(value = "更新任务接口")
=======
>>>>>>> b5dc19de15dcf86a592376c6ba27475bc7288e1a
    public Msg updateMatter(@RequestBody matter matter) {
        return matterService.updateMatter(matter);
    }

    @GetMapping("/delete/{id}")
<<<<<<< HEAD
    @ApiOperation(value = "删除任务接口")
=======
>>>>>>> b5dc19de15dcf86a592376c6ba27475bc7288e1a
    public Msg deleteMatter(@PathVariable int id) {
        return matterService.deleteMatter(id);
    }

    @GetMapping("/updateStatus/{id}/{status}")
<<<<<<< HEAD
    @ApiOperation(value = "id和status更新任务接口")
=======
>>>>>>> b5dc19de15dcf86a592376c6ba27475bc7288e1a
    public Msg updateMatterStatus(@PathVariable int id,@PathVariable String status) {
        return matterService.updateMatterStatus(id,status);
    }

    @GetMapping("/getMatter/{id}")
<<<<<<< HEAD
    @ApiOperation(value = "id获取部门接口")
=======
>>>>>>> b5dc19de15dcf86a592376c6ba27475bc7288e1a
    public Msg getMatterByid(@PathVariable int id) {
        return matterService.getDepartmentByid(id);
    }

    @GetMapping("/getMatterByDepartmentAndUsername/{username}/{department}/{status}")
<<<<<<< HEAD
    @ApiOperation(value = "department和username和status获取任务接口")
=======
>>>>>>> b5dc19de15dcf86a592376c6ba27475bc7288e1a
    public Msg getMatterByid(@PathVariable String username,@PathVariable String department,@PathVariable String status) {
        return matterService.getMattersByDepartmentAndUsername(username,department,status);
    }

}
