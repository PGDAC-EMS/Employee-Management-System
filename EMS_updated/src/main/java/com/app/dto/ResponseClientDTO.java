package com.app.dto;



import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;


import lombok.*;

//import javax.persistence.Column;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ResponseClientDTO {
	@JsonProperty(access = Access.READ_ONLY) 
	private Long id;
	
    private String cName;
   
    private String cCompany;
   
    private String cEmail;
   
    private String cContact;
 
    private String cLocation;
    

}
