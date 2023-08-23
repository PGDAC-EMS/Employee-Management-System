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
	public TaskRepo taskrepo;
	
	
	@Autowired
	private ModelMapper mapper;
	 
	@Override
	public Task save(Task task) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Task update(Task task) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ApiResponse delete(Long id) {
		Task task= taskrepo.findById(id).orElseThrow(()->new ResourceNotFoundException("invalid task id"));
		Project project = task.getProject();
		project.removeProjectTask(task);
		Employee employee = task.getEmp();
		employee.removeTask(task);
		
		
		return new ApiResponse("Task deleted Successfully!!");
		
	}

	@Override
	public List<Task> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TaskDTO findById(Long id) {
		Task task= taskrepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("invalid task id!!"));
		return mapper.map(task, TaskDTO.class);
	}

	@Override
	public List<Task> findByEmpAndApprovalStatus(Long empId, String approvalStatus) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Task> findByApprovalStatus(String status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Task updateStatus(Task task) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Task> findByProject(Long project) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Task editTask(Task t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countByApprovalStatus(String approvalStatus) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long countall() {
		// TODO Auto-generated method stub
		return 0;
	}

}
