package com.app.dto;

import java.time.LocalDate;

import com.app.entities.Department;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AuthResp {	
	private Long id;
	private String firstName;	
	private String lastName;		
	private LocalDate joinDate;
	private double salary;	
	private String location;	
	private Department department;	
}
