package com.app.entities;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude={"emp","project"})
@Entity
@Table(name="tasks")
public class Task extends BaseEntity {
	
	@Column(name = "t_name")
   private String tName;
	
   @Column(name = "t_desc")
   private String tDesc;
   
   @DateTimeFormat(pattern = "yyyy-MM-dd")
   
   @Column( name = "t_assignDate")
   private LocalDate tAssignDate;
   
   @DateTimeFormat(pattern = "yyyy-MM-dd")
  
   @Column(name = "t_endDate")
   private LocalDate tEndDate;
   
   @Column(name = "t_approvalStatus")
   private String approvalStatus;
   
   @DateTimeFormat(pattern = "yyyy-MM-dd")
   
   @Column(
      name = "t_acceptDate"
   )
   private LocalDate tAcceptDate;
   @DateTimeFormat(pattern = "yyyy-MM-dd")
 

   @Column(name = "t_submittedDate")
   private LocalDate tSubmittedDate;
   
   @Column(name = "t_submissionStatus")
   private String tSubmissionStatus;
   @Column(
      name = "t_report"
   )
   private String tReport;
   
   private String remark;
   
   @Column(name = "t_status")
   private String tStatus;
   
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "p_id")
   private Project project;
   
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn( name = "emp_id")
   private Employee emp;

  

}
