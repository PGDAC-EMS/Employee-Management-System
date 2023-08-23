package com.app.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.*;

//import javax.persistence.Column;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UpdateClientDTO {
	@JsonProperty(access = Access.READ_ONLY) 
	private Long id;
	
	
	@JsonProperty(access = Access.READ_ONLY)
    private String cName;
   
	@JsonProperty(access = Access.READ_ONLY)
    private String cCompany;
   
	@NotBlank(message = "Email can't be blank or null!!!")
	@Email(message = "Invalid email format !!!!")
	private String cEmail;
   
    private String cContact;
 
    private String cLocation;

}
