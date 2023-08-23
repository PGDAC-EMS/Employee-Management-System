package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Project;

public interface ProjectRepo extends JpaRepository<Project, Long> {
	   List<Project> findByStatus(String status);

	   int countByStatus(String status);

}
