package com.app.dto;

import java.time.LocalDate;

import java.util.ArrayList;

import java.util.List;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import org.springframework.format.annotation.DateTimeFormat;

import com.app.entities.Task;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UpdateProjectDTO {
	 @JsonProperty(access = Access.READ_ONLY) 
	   private Long id;
	  
	
	//  @JsonProperty(access = Access.READ_ONLY) 
	   private String pName;

//	  @JsonProperty(access = Access.READ_ONLY) 
	   private String pDesc;

	

	//  @JsonProperty(access = Access.READ_ONLY) 
	   private String pCreatedBy;

	  @PastOrPresent
	  @DateTimeFormat(pattern="yyyy-MM-dd")
	 // @JsonProperty(access = Access.READ_ONLY) 
	   private LocalDate pStartDate;

	  @FutureOrPresent
	  @DateTimeFormat(pattern="yyyy-MM-dd")
	  private LocalDate pEndDate;

	  @FutureOrPresent
	  @DateTimeFormat(pattern="yyyy-MM-dd")
	   private LocalDate pSubmittedDate;

	   private String pProgress;
	  
	   private String pReport;

	   private String status;
	
       private Long clientId;
       

     private List<Task> taskList =new ArrayList<>();


}
