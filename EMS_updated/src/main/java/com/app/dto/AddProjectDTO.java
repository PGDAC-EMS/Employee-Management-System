package com.app.dto;

import java.time.LocalDate;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import org.springframework.format.annotation.DateTimeFormat;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AddProjectDTO {
	  @JsonProperty(access = Access.READ_ONLY) 
	   private Long id;
	  
	  @NotBlank
	   private String pName;

	  @NotBlank
	   private String pDesc;

	  @NotBlank
	   private String pCreatedBy;

	  @PastOrPresent
	  @DateTimeFormat(pattern="yyyy-MM-dd")
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
	   
	   @NotNull
	   private Long clientId;

}
