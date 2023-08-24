package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.dto.AddEmpDTO;
import com.app.dto.AuthRequest;
import com.app.dto.AuthResp;
import com.app.dto.ForgotPasswordDTO;
import com.app.dto.ResponseEmpDTO;
import com.app.dto.UpdateEmpDTO;
import com.app.entities.Employee;
import com.app.exception.ApiException;



public interface EmployeeService {
	List<ResponseEmpDTO> findAll();

   List<Employee> findByManagerId(Long mid);

   ResponseEmpDTO findByEmail(String email);

   List<Employee> findByDepartment(Long deptId);

   AuthResp authenticate(AuthRequest dto);

   ResponseEmpDTO addEmp(AddEmpDTO  emp);

   //ResponseEmpDTO update(UpdateEmpDTO emp);

   //ResponseEmpDTO forgetPassword(Employee emp);

   ResponseEmpDTO updateProfilePicture(String email, String file);

    Employee getEmpDetails(Long empId);

	ResponseEmpDTO forgetPassword(ForgotPasswordDTO emp);

	ResponseEmpDTO updateEmployee(Long empId, UpdateEmpDTO dto);

}
