package com.amaz.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amaz.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
