package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.AddProjectDTO;
import com.app.dto.ApiResponse;
import com.app.dto.ResponseClientDTO;
import com.app.dto.ResponseEmpDTO;
import com.app.dto.ResponseProjectDTO;
import com.app.dto.UpdateProjectDTO;
import com.app.entities.Client;
import com.app.entities.Department;
import com.app.entities.Employee;
import com.app.entities.Project;
import com.app.exception.ResourceNotFoundException;
import com.app.repository.ClientRepo;
import com.app.repository.ProjectRepo;




@Service
@Transactional
public class ProjectServiceImpl  implements ProjectService{
	
	@Autowired
	private ProjectRepo projectDao;
	
	@Autowired
	private ClientRepo clientDao;
	
	@Autowired
	private ModelMapper mapper;
	
	 @Autowired
	 private EntityManager entityManager;

	@Override
	public ResponseProjectDTO addProject(AddProjectDTO pro) {
		Client client = clientDao.findById(pro.getClientId())
				.orElseThrow(() -> new ResourceNotFoundException("Invalid client id!!!"));
		
		Project project= mapper.map(pro, Project.class);
		client.addProject(project);
		return mapper.map(projectDao.save(project), ResponseProjectDTO.class);
		
	}

	@Override
	public Project updateProject(Long projectId ,UpdateProjectDTO pro) {
		Project project=mapper.map(findById(projectId), Project.class);
//		Client client = clientDao.findById(pro.getClientId())
//				.orElseThrow(() -> new ResourceNotFoundException("Invalid client id!!!"));
//		pro.setPCreatedBy(project.getPCreatedBy());
//		pro.setPDesc(project.getPDesc());
//		pro.setPName(project.getPName());
//		pro.setPStartDate(project.getPStartDate());
//		pro.setClientId(project.getClient().getId());
		mapper.map(pro, project);
		project.setId(projectId);
		//client.addProject(project);
		Project updatedProject = entityManager.merge(project);
		return updatedProject;
	}
	
	
	

	@Override
	public ResponseProjectDTO findById(Long id) {
		Project project=projectDao.findById(id).orElseThrow(()-> new ResourceNotFoundException("invalid project Id!!"));
		return mapper.map(project,ResponseProjectDTO.class);
	}

	@Override
	public ApiResponse delete(Long projectId) {
		Project project=mapper.map(findById(projectId), Project.class);
		projectDao.delete(project);
		return new ApiResponse("project deleted Successfully!!");
	}

	@Override
	public List<ResponseProjectDTO> findAll() {
		List<Project> projectList=projectDao.findAll();
		return projectList.stream()
				.map(project -> mapper.map(project,ResponseProjectDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<ResponseProjectDTO> findByStatus(String status) {
		// TODO Auto-generated method stub
		List<Project> projectList= projectDao.findByStatus(status);
		return projectList.stream() 
				.map(project -> mapper.map(project, ResponseProjectDTO.class)) 
				.collect(Collectors.toList());
	}

	@Override
	public int countByStatus(String status) {
		return projectDao.countByStatus(status);
	}

	@Override
	public long countAll() {
		return projectDao.count();
	}

	@Override
	public Project update(Long projectId ,Project pro) {
		Project project = mapper.map(findById(projectId), Project.class);
		project.setPName(pro.getPName());
		project.setPDesc(pro.getPDesc());
		project.setPStartDate(pro.getPStartDate());
		project.setPEndDate(pro.getPEndDate());
		project.setPSubmittedDate(pro.getPSubmittedDate());
		project.setPProgress(pro.getPProgress());
		project.setPReport(pro.getPReport());
		project.setStatus(pro.getStatus());
		return projectDao.save(pro) ;
	}

}
