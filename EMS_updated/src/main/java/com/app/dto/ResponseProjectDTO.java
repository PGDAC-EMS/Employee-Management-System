package com.app.dto;

import java.time.LocalDate;


import lombok.*;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ResponseProjectDTO {
	   private Long id;
	   
	   private String pName;

	   private String pDesc;

	   private String pCreatedBy;

	   private LocalDate pStartDate;

	   private LocalDate pEndDate;

	   private LocalDate pSubmittedDate;

       private ClientDTO client;
       
	   private String status;

}
