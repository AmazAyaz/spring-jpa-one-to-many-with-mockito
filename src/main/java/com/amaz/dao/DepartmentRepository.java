package com.amaz.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amaz.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{

    public Department findDepartmentByName(String name);
    public Department findDepartmentById(Long id);
}
