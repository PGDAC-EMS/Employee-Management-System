package com.app.service;

import java.util.List;
import com.app.dto.ApiResponse;
import com.app.dto.TaskDTO;
import com.app.entities.Task;

public interface TaskService {
   Task save(Task task);

   Task update(Task task);

   ApiResponse delete(Long id);

   List<Task> findAll();

   TaskDTO findById(Long id);

   List<Task> findByEmpAndApprovalStatus(Long empId, String approvalStatus);

   List<Task> findByApprovalStatus(String status);

   Task updateStatus(Task task);

   List<Task> findByProject(Long project);

   Task editTask(Task t);

   int countByApprovalStatus(String approvalStatus);

   long countall();

}
