package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entities.Project;
import com.app.entities.Task;

public interface TaskRepo extends JpaRepository<Task,Long> {
	   @Query(value = "SELECT * FROM tasks where id = ?1 AND t_approval_status = ?2",nativeQuery = true)
	   List<Task> findByEmpAndApprovalStatus(Long empId, String approvalStatus);

	   List<Task> findByApprovalStatus(String approvalStatus);

	   @Query(
	      value = "SELECT * FROM tasks where id = ?1 ",
	      nativeQuery = true
	   )
	   List<Task> findByProject(Long projectId);

	   int countByApprovalStatus(String approvalStatus);

}
