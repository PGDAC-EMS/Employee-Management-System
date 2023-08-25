package com.app.controller;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AddEmpDTO;
import com.app.dto.AuthRequest;
import com.app.dto.ForgotPasswordDTO;
import com.app.dto.UpdateEmpDTO;
import com.app.entities.Employee;
import com.app.service.EmployeeService;

import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin
@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService empService;

//	@Autowired
//	private ImageHandlingService imgService;

	// 1. add new emp to existing dept
	// http://host:port/employees , method=POST , request payload : AddEmp dto
	// containing dept id
	@PostMapping
	public ResponseEntity<?> addEmpToExistingDept(@RequestBody @Valid AddEmpDTO dto) {
		System.out.println("in add emp " + dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(empService.addEmp(dto));
	}
	
	@PutMapping("/Profile/{empId}")
	public ResponseEntity<?> updateEmployeeProfile(@PathVariable Long empId,@RequestBody @Valid UpdateEmpDTO dto){
		dto.setId(empId);
		//for setting other values as it is we have to first get the employee by empId & then use setter;
		System.out.println("in update emp " + dto.getId());// not null
		// validate
		
		empService.getEmpDetails(dto.getId());
		// => emp exists by the id --> continue to update
		return ResponseEntity.status(HttpStatus.OK).body(empService.updateEmployee(dto.getId(),dto));
		
	}
	
	@PostMapping("/signIn")
	public ResponseEntity<?> authenticateEmp(@RequestBody @Valid AuthRequest request) {
		System.out.println("in sign in " + request);
	
			return new ResponseEntity<>(empService.authenticate(request), 
					HttpStatus.OK);

	}
	
	@PutMapping("/forgetPassword")
	public ResponseEntity<?> changePassword ( @RequestBody  @Valid ForgotPasswordDTO emp ) {
			return ResponseEntity.status(HttpStatus.OK).body(empService.forgetPassword(emp));
	}
	
	
	@GetMapping
	public ResponseEntity<?> getAllEmployees(){
		return ResponseEntity.status(HttpStatus.OK).body(empService.findAll());
	}
}
