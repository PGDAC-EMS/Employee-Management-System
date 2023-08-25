package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.ApiResponse;
import com.app.dto.TaskDTO;
import com.app.entities.Department;
import com.app.entities.Employee;
import com.app.entities.Project;
import com.app.entities.Task;
import com.app.exception.ResourceNotFoundException;
import com.app.repository.DepartmentRepo;
import com.app.repository.ProjectRepo;
import com.app.repository.TaskRepo;


@Service
@Transactional
public class TaskServiceImpl  implements TaskService{

	@Autowired
	public TaskRepo taskDao;
	
	
	@Autowired
	private ModelMapper mapper;
	 
	@Override
	public Task save(TaskDTO task) {
		Task t=mapper.map(task, Task.class);
		return taskDao.save(t);
	}

	

	@Override
	public ApiResponse delete(Long id) {
		Task task= taskDao.findById(id).orElseThrow(()->new ResourceNotFoundException("invalid task id"));
		Project project = task.getProject();
		project.removeProjectTask(task);
		Employee employee = task.getEmp();
		employee.removeTask(task);
		return new ApiResponse("Task deleted Successfully!!");
		
	}

	@Override
	public List<Task> findAll() {
		return taskDao.findAll();
	}

	@Override
	public Task findById(Long id) {
		Task task= taskDao.findById(id).orElseThrow(()-> new ResourceNotFoundException("invalid task id!!"));
		return task;
	}

	@Override
	public List<Task> findByEmpAndApprovalStatus(Long empId, String approvalStatus) {
		return taskDao.findByEmpAndApprovalStatus( empId, approvalStatus);
	}

	@Override
	public List<Task> findByApprovalStatus(String status) {
		return taskDao.findByApprovalStatus(status);
	}

	@Override
	public Task updateStatus(Task task) {
		Task task1 = findById(task.getId());
		task1.setApprovalStatus(task.getApprovalStatus());
		task1.setTStatus(task.getTStatus() );
		task1.setTAcceptDate(task.getTAcceptDate());
		return taskDao.save(task);
	}

	@Override
	public List<Task> findByProject(Long project) {
		List<Task> proj = taskDao.findByProject(project);
		return proj;
	}

	@Override
	public Task editTask(Task t) {
		Task task = findById(t.getId());
		task.setTName(t.getTName());
		task.setEmp(t.getEmp());
		task.setApprovalStatus(t.getApprovalStatus());
		task.setTAssignDate(t.getTAssignDate());
		task.setTEndDate(t.getTEndDate());
		task.setTDesc(t.getTDesc());
		task.setRemark(t.getRemark());
		return  taskDao.save(task);
	}

	@Override
	public int countByApprovalStatus(String approvalStatus) {
		return taskDao.countByApprovalStatus(approvalStatus);
	}

	@Override
	public long countall() {
		return taskDao.count();
	}



	@Override
	public Task update(Task t) {
		Task task = findById(t.getId());
		task.setTReport(t.getTReport());
		task.setTSubmittedDate(t.getTSubmittedDate());
		task.setTStatus(t.getTStatus());
		task.setTSubmissionStatus(t.getTSubmissionStatus());
		return  taskDao.save(task);
	}

}
