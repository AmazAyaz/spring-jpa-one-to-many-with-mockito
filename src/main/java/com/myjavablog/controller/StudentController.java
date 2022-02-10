package com.myjavablog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myjavablog.model.Department;
import com.myjavablog.model.Student;
import com.myjavablog.service.DepartmentService;
import com.myjavablog.service.StudentService;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @Autowired
    DepartmentService departmentService;

    @RequestMapping(value = "/studentList", method = RequestMethod.GET)
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @PostMapping("/saveStudent/{deptName}")
    public String saveStudent(@RequestBody List<Student> studentList, @PathVariable String deptName){
        try {
            Department dept = departmentService.findDepartment(deptName.toUpperCase());

            for(Student student: studentList)
                student.setDepartment(dept);

            studentService.saveStudent(studentList);
            return "Student saved successfully..";
        }catch (Exception ex){
            ex.printStackTrace();
            return "Error in saving Student ..";
        }
    }
}
