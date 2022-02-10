package com.amaz.service;

import java.util.List;

import com.amaz.model.Student;

public interface StudentService {

    public void saveStudent(List<Student> studentList);

    public List<Student> getStudents();

}