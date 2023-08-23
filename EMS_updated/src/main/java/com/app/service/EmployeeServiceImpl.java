package com.app.service;


import java.util.List;
import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.dto.AddEmpDTO;
import com.app.dto.ApiResponse;
import com.app.dto.AuthRequest;
import com.app.dto.AuthResp;
import com.app.dto.ForgotPasswordDTO;
import com.app.dto.ResponseEmpDTO;
import com.app.dto.UpdateEmpDTO;
import com.app.entities.Department;
import com.app.entities.Employee;
import com.app.exception.ApiException;
import com.app.exception.ResourceNotFoundException;
import com.app.repository.DepartmentRepo;
import com.app.repository.EmployeeRepo;
//import com.app.utils.StorageService;

@Transactional
@Service
public class EmployeeServiceImpl implements EmployeeService {
	   @Autowired
	   private EmployeeRepo empDao;
	   
	   @Autowired
	   private DepartmentRepo deptDao;
	   
	   @Autowired
		private ModelMapper mapper;
	   
//	   @Autowired
//	   private StorageService storageService;
//	   @Autowired
//	   public PasswordEncoder passwordEncoder;

	   public EmployeeServiceImpl() {
		  
	   }
	   @Override
		public Employee getEmpDetails(Long empId) {
			// TODO Auto-generated method stub
			return empDao.findById(empId).orElseThrow(() -> new ResourceNotFoundException("Emp id invalid !!!!!"));
		}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return empDao.findAll();
	}

	@Override
	public List<Employee> findByManagerId(Long mid) {
		// TODO Auto-generated method stub
		return empDao.findByManagerId(mid);
	}

	@Override
	public List<Employee> findByDepartment(Long deptId) {
		// TODO Auto-generated method stub
		
		return empDao.findByDept(deptId);
	}



	@Override
	public ResponseEmpDTO findByEmail(String email) {
		// TODO Auto-generated method stub
		Employee emp= empDao.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("Invalid emailId !!!!"));
		return mapper.map(emp,ResponseEmpDTO.class);
	}

	@Override
	public AuthResp authenticate(AuthRequest request) {
		Employee emp=empDao.
				findByEmailAndPassword(request.getEmail(), request.getPassword())
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Email or Password !!!!!"));
		//=> valid login --> map Entity --> DTO
		//ModelMapper API : public T map(Object src , Class<T> class)
		return mapper.map(emp, AuthResp.class);
	}

	@Override
	public ResponseEmpDTO addEmp(AddEmpDTO emp) {

		Department dept = deptDao.findById(emp.getDeptId())
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Dept id !!!"));
		// dept : PERSISTENT
		// set up a bi dir relationship
		Employee employee = mapper.map(emp, Employee.class);
		dept.addEmployee(employee);//cascade on save
		//IMPORTANT : since you have not explicitly called save : hib has NOT YET assigned the id
		//only for sending correct id to the REST clnt --> call save
		// map entity --> dto n return
		return mapper.map(empDao.save(employee), ResponseEmpDTO.class);
			

	}
	
	@Override
	public ResponseEmpDTO updateEmployee(Long empId, UpdateEmpDTO dto) {
		// validate if emp exists by id
		Employee emp = empDao.findById(empId)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Emo ID , Emp not found !!!!"));
		// => emp exists
		Department dept = deptDao.findById(dto.getDeptId())
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Dept Id!!!"));
		// dto contains the updates , so apply it --> to entity
		mapper.map(dto, emp);// but after this id : null
		emp.setId(empId);// so setting it again
		// System.out.println("after mapping " + emp);
		dept.addEmployee(emp);
		return mapper.map(emp,ResponseEmpDTO.class);
	

	}


//	@Override
//	public ResponseEmpDTO update(UpdateEmpDTO data) {
//		// TODO Auto-generated method stub
//		Employee emp = mapper.map(findByEmail(data.getEmail()),Employee.class);
//		emp.setFirstName(data.getFirstName());
//		emp.setLastName(data.getLastName());
//		emp.setEmail(data.getEmail());
//		emp.setGender(data.getGender());
//		emp.setContact(data.getContact());
//		emp.setBirthDate(data.getBirthDate());
//		emp.setAddress(data.getAddress());
//		emp.setSecurityQuestion(data.getSecurityQuestion());
//		return mapper.map(empDao.save(emp),ResponseEmpDTO.class);
//	}
	
	
	//this is neither working nor throwing any error : status code: 200

	@Override
	public ResponseEmpDTO forgetPassword(ForgotPasswordDTO emp) {
		// TODO Auto-generated method stub
		Employee employee = mapper.map(findByEmail(emp.getEmail()),Employee.class);
		//if empId and securityQuestion matches then set password as new password
	    if(emp.getEmail().equals(employee.getEmail()) && emp.getSecurityQuestion().equals(employee.getSecurityQuestion())) {
	    	String newPasswd=emp.getNewPassword();
	    	employee.setPassword(newPasswd);
	    	return mapper.map(empDao.save(employee),ResponseEmpDTO.class);
	    }
	    return null;
	}

	@Override
	public ResponseEmpDTO updateProfilePicture(String email, String file) {
		// TODO Auto-generated method stub
		return null;
	}

}
