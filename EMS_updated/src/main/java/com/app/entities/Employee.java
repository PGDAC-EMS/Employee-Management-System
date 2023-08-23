	package com.app.entities;

import java.time.LocalDate;
import java.util.ArrayList;
//import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude= {"dept","empTaskList"})
@Entity
@Table(name="employees")
public class Employee  extends BaseEntity{
	  
	   @Column(name="first_name")
	   private String firstName;
	   
	   @Column(name="last_name")
	   private String lastName;
	   
	   @NotBlank
	   @Column(length=30,unique=true)
	   private String email;
	   
	   private String password;
	   
	   private String designation;
	   
	   @Column(name = "manager_id")
	   private Long managerId;
	   
	   @DateTimeFormat(pattern = "yyyy-MM-dd")
	 
	   @Column(name = "joinDate",updatable = false)
	   private LocalDate joinDate;
	   
	   private Double salary;
	   
	   private String gender;
	   
	   private String contact;
	   
	   @DateTimeFormat(pattern = "yyyy-MM-dd")
	
	   @Column( name = "birthDate")
	   private LocalDate birthDate;
	   
	   private String address;
	   
	   private String profilePicture;
	   
	   private String securityQuestion;
	   
	   
	   
	   @ManyToOne
	   @JoinColumn(name = "dept_id")
	   private Department dept;
	   
	   @OneToMany(mappedBy = "emp",orphanRemoval=true,cascade=CascadeType.ALL)
	   private List<Task> empTaskList=new ArrayList<>();
	   
	   public void addTask(Task t) {
		   empTaskList.add(t);
		   t.setEmp(this);
	   }
       
	   public void removeTask(Task t) {
		   empTaskList.remove(t);
		   t.setEmp(null);
	   }
	   
	   public Employee(String firstName, String lastName, String email, String password) {
			super();
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
			this.password = password;
		}
	   

}
