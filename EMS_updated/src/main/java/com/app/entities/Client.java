package com.app.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.hibernate.collection.internal.PersistentList;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude="projectList")
@Entity
@Table(name="clients")
public class Client extends BaseEntity {
	
	   @Column(name = "c_Name")
	   private String cName;
	   
	   @Column(name = "c_Company")
	   private String cCompany;
	   
	   @Column(name = "c_email",unique=true)
	   private String cEmail;
	   
	   @Column(name = "c_contact")
	   private String cContact;
	   
	   @Column(name = "c_location")
	   private String cLocation;
	   
	   @OneToMany(mappedBy = "client",orphanRemoval=true,cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	   private List<Project> projectList=new ArrayList<>();
	   
	   public void setProjectList(List<Project> projectList) {
		   if(projectList instanceof PersistentList)
	           this.projectList = projectList;
		   else {
			   this.projectList.clear();
			   this.projectList.addAll(projectList);
		   }
	   }
	   
	   public void addProject(Project p) {
		   projectList.add(p);
		   p.setClient(this);
	   }
	   
	   public void removeProject(Project p) {
		   projectList.remove(p);
		   p.setClient(null);
	   }

			  

}
