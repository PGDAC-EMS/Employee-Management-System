package com.app.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude="empList")
@Entity
@Table(name="departments")
public class Department extends BaseEntity {
	
	@Column(name = "dept_Name",length=30)
    private String deptName;
	
	@Column(name="dept_location",length=30)
	private String location;
	
   @Column(name = "manager_id")
   private Long managerId;
   
   @OneToMany(mappedBy = "dept",orphanRemoval=true,cascade=CascadeType.ALL)
   private List<Employee> empList=new ArrayList<>();
   
   public void addEmployee(Employee e) {
	   empList.add(e);
	   e.setDept(this);
	   
   }
   public void removeEmployee(Employee e) {
	   empList.remove(e);
	   e.setDept(null);
   }

  

}
