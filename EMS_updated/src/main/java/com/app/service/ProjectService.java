package com.app.service;

import java.util.List;

import com.app.dto.AddProjectDTO;
import com.app.dto.ApiResponse;
import com.app.dto.ResponseProjectDTO;
import com.app.dto.UpdateProjectDTO;
import com.app.entities.Project;

public interface ProjectService {
	ResponseProjectDTO addProject(AddProjectDTO pro);

   Project updateProject( Long projectId,UpdateProjectDTO pro);

   ResponseProjectDTO findById(Long id);

   ApiResponse delete(Long projectId);

   List<ResponseProjectDTO> findAll();

   List<ResponseProjectDTO> findByStatus(String status);

   int countByStatus(String status);

   long countAll();
   
   Project update(Long projectId, Project pro);

}
