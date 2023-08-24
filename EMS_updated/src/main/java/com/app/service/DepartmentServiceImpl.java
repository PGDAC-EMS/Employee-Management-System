package com.app.service;

import java.util.List;
//import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.DepartmentDTO;
import com.app.dto.DepartmentEmpsDTO;
import com.app.entities.Department;
import com.app.exception.ResourceNotFoundException;
import com.app.repository.DepartmentRepo;


@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService{
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private DepartmentRepo deptDao;

	@Override
	public List<DepartmentDTO> findAll() {
		List<Department> deptList=deptDao.findAll();
		return deptList.stream()
				.map(dept->mapper.map(dept, DepartmentDTO.class))
				.collect(Collectors.toList());
	}
	
	@Override
	public DepartmentDTO getDepartmentDetails(Long deptId) {
		Department dept=deptDao.findById(deptId).
		orElseThrow(() -> new ResourceNotFoundException("Invalid Dept Id !!!!"));
		return mapper.map(dept,DepartmentDTO.class);
				
	}

	@Override
	public Department findByDeptId(Long id) {
		// TODO Auto-generated method stub
		return deptDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("dept id invalid !!!!!"));
	}
	
	@Override
	public DepartmentDTO addNewDepartment(DepartmentDTO dept) {
		Department departmentEntity = mapper.map(dept, Department.class);
		Department persistentDept = deptDao.save(departmentEntity);
		return mapper.map(persistentDept, DepartmentDTO.class);
	}
	@Override
	public DepartmentEmpsDTO getDepartmentAndEmpDetails(Long deptId) {		
		Department department = deptDao.getDepartmentAndEmpDetails(deptId);
		return mapper.map(department,DepartmentEmpsDTO.class);
	}
}
