package com.app.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.Pattern;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.*;




@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AddEmpDTO {
	  @JsonProperty(access = Access.READ_ONLY) 
	   private Long id;
	  
	   private String firstName;
	   
	   private String lastName;
	   
	   @NotBlank(message = "Email can't be blank or null!!!")
	   @Email(message = "Invalid email format !!!!")
	   private String email;
	   
	   @NotBlank(message = "Password required !!!!")
	   //@Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})", message = "Blank or invalid password !!!")
	   private String password;
	   
	   private String designation;
	   
	 
	   private int managerId;
	   
	   @DateTimeFormat(pattern = "yyyy-MM-dd")
	   private LocalDate joinDate;
	   
	   private double salary;
	   
	   private String gender;
	   
	   private String contact;
	   
	   @DateTimeFormat(pattern = "yyyy-MM-dd")
	   private LocalDate birthDate;
	   
	   private String address;
	   
	   private String profilePicture;
	   
	   private String securityQuestion;
	   
	   private Long deptId;

}
