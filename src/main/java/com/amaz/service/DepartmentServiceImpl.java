package com.amaz.service;

import com.amaz.dao.DepartmentRepository;
import com.amaz.exception.NotFoundException;
import com.amaz.model.Department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    //@Transactional
    public void saveDepartment(Department department) {
        departmentRepository.save(department);
    }

    @Override
    public List<Department> getDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department findDepartment(String name) throws NotFoundException {
        //Optional<Department> d = departmentRepository.findDepartmentByName(name);
        Department d = departmentRepository.findDepartmentByName(name);
        //Department department = d.orElseThrow(() -> new NotFoundException("Not found"));
        //Department result = d.get();
        return d;
    }
}
