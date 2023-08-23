package com.app.service;

import java.util.List;
//import java.util.Optional;

import com.app.dto.DepartmentDTO;
import com.app.dto.DepartmentEmpsDTO;
import com.app.entities.Department;

public interface DepartmentService {
	
	List<Department> findAll();

	//Optional<Department> findById(int id);

	DepartmentDTO addNewDepartment(DepartmentDTO dept);

	Department findByDeptId(Long id);

	DepartmentDTO getDepartmentDetails(Long deptId);

	DepartmentEmpsDTO getDepartmentAndEmpDetails(Long deptId);
	

}
