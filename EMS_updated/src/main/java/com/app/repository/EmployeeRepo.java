package com.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Department;
import com.app.entities.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
	   Optional<Employee> findByEmail(String email);

	   List<Employee> findByDept(Long deptId);

	   List<Employee> findByManagerId(Long mid);
	   Optional<Employee> findByEmailAndPassword(String em,String pass);

}
