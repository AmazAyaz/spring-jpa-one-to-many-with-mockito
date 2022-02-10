package com.myjavablog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myjavablog.model.Department;
import com.myjavablog.service.DepartmentService;

@RestController
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @PostMapping("/saveDept")
    public String saveDepartment(@RequestBody Department department){
        departmentService.saveDepartment(department);
        return "Saved successfully...";
    }

    @RequestMapping(value = "/departmentList", method = RequestMethod.GET)
    public List<Department> getDepartments(){
        return departmentService.getDepartments();
    }

}
