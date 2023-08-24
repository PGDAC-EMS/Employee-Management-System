package com.app.dto;
import java.time.LocalDate;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.app.entities.Employee;
import com.app.entities.Project;
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
public class TaskDTO {

	private String tName;
		

	private String tDesc;
	   
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate tAssignDate;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate tEndDate;
	   
	private String approvalStatus;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate tAcceptDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate tSubmittedDate;


	private String tSubmissionStatus;

	private String tReport;

	private String remark;

	private String tStatus;
	
	private Project ProjectId;
	
	private Employee EmpId;

}
