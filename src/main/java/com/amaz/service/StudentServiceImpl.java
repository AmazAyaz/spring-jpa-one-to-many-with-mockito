package com.amaz.service;

import com.amaz.dao.StudentRepository;
import com.amaz.model.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void saveStudent(List<Student> studentList) {
        studentRepository.saveAll(studentList);
    }

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }
}
