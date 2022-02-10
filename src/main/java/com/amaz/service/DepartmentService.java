package com.amaz.service;

import com.amaz.exception.NotFoundException;
import com.amaz.model.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {

    public void saveDepartment(Department department);
    public List<Department> getDepartments();
    public Department findDepartment(String name) throws NotFoundException;
}
