package com.app.entities;

import java.time.LocalDate;
//import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.hibernate.collection.internal.PersistentList;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude= {"client","projectTaskList"})
@Entity
@Table(name="projects")
public class Project extends BaseEntity {
	
	@Column(name = "p_name")
   private String pName;
	
   @Column(name = "p_desc")
   private String pDesc;
   
   @Column(name = "p_createdBy")
   private String pCreatedBy;
   
   @DateTimeFormat(pattern = "yyyy-MM-dd")
  
   @Column(name = "p_startDate")
   private LocalDate pStartDate;
   
   @DateTimeFormat(pattern = "yyyy-MM-dd")
 
   @Column(name = "p_endDate")
   private LocalDate pEndDate;
   
   @DateTimeFormat(pattern = "yyyy-MM-dd")
  
   @Column(name = "p_submittedDate" )
   private LocalDate pSubmittedDate;
   
   @Column(name = "p_progress")
   private String pProgress;
   
   @Column(name = "p_report")
   private String pReport;
   
   @Column(name = "p_status")
   private String status;
   
   @ManyToOne
   @JoinColumn(name = "c_id")
   private Client client;
   
   @OneToMany(mappedBy = "project",cascade=CascadeType.ALL,orphanRemoval = true)
   private List<Task> projectTaskList;
   
   public void setProjectTaskList(List<Task> projectTaskList) {
	    if (projectTaskList instanceof PersistentList) {
	        this.projectTaskList = projectTaskList;
	    } else {
	        this.projectTaskList.clear();
	        this.projectTaskList.addAll(projectTaskList);
	    }
	}

   
   
   public void addProjectTask(Task t) {
	   projectTaskList.add(t);
	   t.setProject(this);
   }
   
   public void removeProjectTask(Task t) {
	   projectTaskList.remove(t);
	   t.setProject(null);
   }

   

}
