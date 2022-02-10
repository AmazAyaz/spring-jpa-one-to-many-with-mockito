package com.myjavablog;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.amaz.dao.DepartmentRepository;
import com.amaz.dao.StudentRepository;
import com.amaz.model.Department;
import com.amaz.service.DepartmentService;
import com.amaz.service.StudentService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootJpaOneToManyDemoApplicationTests {

	@MockBean
	private StudentRepository studentRepository;

	@MockBean
	private DepartmentRepository departmentRepository;

	@Test
	public void saveDepartmentTest() {
		Department dept = new Department();
		dept.setName("IT");
		when(departmentRepository.save(dept)).thenReturn(dept);
		assertEquals(dept, departmentRepository.save(dept));
	}

	@Test
	public void getDepartmentTest() {
		Department dept = new Department();
		dept.setName("IT");
		Department dept1 = new Department();
		dept1.setName("sales");
		ArrayList<Department> al = new ArrayList<>();
		al.add(dept);
		al.add(dept1);
		when(departmentRepository.findAll()).thenReturn(al);
		assertEquals(2, al.size());
	}

	@Test
	public void findDepartmentTest() {

		Department dept = new Department();
		dept.setName("IT");
		when(departmentRepository.findDepartmentByName(dept.getName())).thenReturn(dept);
		assertEquals("IT", dept.getName());

	}

}
