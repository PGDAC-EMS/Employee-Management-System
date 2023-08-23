package com.app.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ClientDTO {
	@JsonProperty(access = Access.READ_ONLY) 
	private Long id;
	
    private String cName;
   
    private String cCompany;
   
    private String cEmail;
   
    private String cContact;
 
    private String cLocation;

	public static void main(String[] args) {
	
	}

}
