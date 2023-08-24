package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AddProjectDTO;
import com.app.dto.ResponseProjectDTO;
import com.app.dto.UpdateProjectDTO;
import com.app.entities.Project;
import com.app.service.ProjectService;

@RestController
@RequestMapping("/projects")
@Validated
public class ProjectController {
	@Autowired
	private ProjectService proService;
	
	@PostMapping
	public ResponseEntity<?> addingProject(@RequestBody @Valid AddProjectDTO project){
		return ResponseEntity.status(HttpStatus.CREATED).body(proService.addProject(project));
	}
	
	@GetMapping("/project/{projectId}")
	public ResponseEntity<?> getProjectById(@PathVariable Long projectId){
		return ResponseEntity.status(HttpStatus.OK).body(proService.findById(projectId));
	}
	
	@GetMapping("/{status}")
	public ResponseEntity<?> getProjectByStatus(@PathVariable String status){
		return ResponseEntity.status(HttpStatus.OK).body(proService.findByStatus(status));
	}

	@GetMapping("/count/{status}")
	public ResponseEntity<?> getCountByStatus(@PathVariable String status){
		return ResponseEntity.status(HttpStatus.OK).body(proService.countByStatus(status));
	}
	
	@GetMapping("/count")
	public ResponseEntity<?> getCountByStatus(){
		return ResponseEntity.status(HttpStatus.OK).body(proService.countAll());
	}
	@GetMapping
	public ResponseEntity<?> getAllProject(){
		return ResponseEntity.status(HttpStatus.OK).body(proService.findAll());
	}
	
	@DeleteMapping("/{projectId}")
	public ResponseEntity<?> deleteProject(@PathVariable Long projectId){
		return ResponseEntity.status(HttpStatus.OK).body(proService.delete(projectId));
	}
	
	@PutMapping("/{projectId}")
	public ResponseEntity<?> updatingProject(@PathVariable Long projectId,@RequestBody @Valid UpdateProjectDTO pro){
		pro.setId(projectId);
//		ResponseProjectDTO project1=proService.findById(projectId);
//		pro.setPCreatedBy(project1.getPCreatedBy());
//		pro.setPDesc(project1.getPDesc());
//		pro.setPName(project1.getPName());
//		pro.setPStartDate(project1.getPStartDate());
//		pro.setClientId(project1.getClient().getId());
		return ResponseEntity.status(HttpStatus.OK).body(proService.updateProject(pro.getId(),pro));
	}
	@PutMapping("/project/{projectId}")
	public ResponseEntity<?> updatingProject(@PathVariable Long projectId,@RequestBody @Valid Project pro){
		pro.setId(projectId);

		return ResponseEntity.status(HttpStatus.OK).body(proService.update(projectId,pro));
	}
}
