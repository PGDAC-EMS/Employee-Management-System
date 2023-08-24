package com.app.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
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
public class UpdateEmpDTO {
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
	   
	   //@JsonProperty(access = Access.READ_ONLY) 
	   private String designation;
	   
	   //@JsonProperty(access = Access.READ_ONLY) 
	   private Long managerId;
	   
	   @JsonProperty(access = Access.READ_ONLY) 
	   @DateTimeFormat(pattern = "yyyy-MM-dd")
	   private LocalDate joinDate;
	   
	   @JsonProperty(access = Access.READ_ONLY) 
	   private double salary;
	   
	   @JsonProperty(access = Access.READ_ONLY)
	   private String gender;
	   
	   private String contact;
	   
	   @JsonProperty(access = Access.READ_ONLY) 
	   @DateTimeFormat(pattern = "yyyy-MM-dd")
	   private LocalDate birthDate;
	   
	   private String address;
	   
	   private String profilePicture;
	   
	   private String securityQuestion;
	   
	   //@JsonProperty(access = Access.READ_ONLY)
	   private Long deptId;

}
