package com.kanban.demo.controller;

import com.kanban.demo.entity.Msg;
import com.kanban.demo.entity.matter;
import com.kanban.demo.service.ContentService;
import com.kanban.demo.service.MatterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/matter")
public class MatterController {
    @Autowired
    MatterService matterService;

    @GetMapping("/task/{mattername}")
    public Msg getMatterByName(@PathVariable String mattername) {
        return matterService.getMatterByName(mattername);
    }

    @GetMapping("/getById/{id}")
    public Msg getMatterById(@PathVariable int id) {
        return matterService.getMatterById(id);
    }


    @GetMapping("/flow/all/{department}")
    public Msg getMatterByDepartment(@PathVariable String department) {
        return matterService.getMatterByDepartment(department);
    }

    @GetMapping("/alldepartments")
    public Msg getAllDepartments() {
        return matterService.getAllDepartments();
    }

    @GetMapping("/allmatters")
    public Msg getAllMatters() {
        return matterService.getAllMatters();
    }

    @GetMapping("/flow/status/{department}/{status}")
    public Msg getMatterByDepartmentandStatus(@PathVariable String department,@PathVariable String status) {
        return matterService.getMatterByDepartmentandstatus(department,status);
    }

    @PostMapping("/add")
    public Msg addMatter(@RequestBody matter matter) {
        return matterService.insert(matter);
    }

    @PostMapping("/update")
    public Msg updateMatter(@RequestBody matter matter) {
        return matterService.updateMatter(matter);
    }

    @GetMapping("/delete/{id}")
    public Msg deleteMatter(@PathVariable int id) {
        return matterService.deleteMatter(id);
    }

    @GetMapping("/updateStatus/{id}/{status}")
    public Msg updateMatterStatus(@PathVariable int id,@PathVariable String status) {
        return matterService.updateMatterStatus(id,status);
    }

    @GetMapping("/getMatter/{id}")
    public Msg getMatterByid(@PathVariable int id) {
        return matterService.getDepartmentByid(id);
    }

    @GetMapping("/getMatterByDepartmentAndUsername/{username}/{department}/{status}")
    public Msg getMatterByid(@PathVariable String username,@PathVariable String department,@PathVariable String status) {
        return matterService.getMattersByDepartmentAndUsername(username,department,status);
    }

}
