package com.app.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entities.Department;

public interface DepartmentRepo extends JpaRepository<Department,Long> {
	Optional<Department> findById(Long deptId);

	@Query("select d from Department d left join fetch d.empList where d.id=?1")
	Department getDepartmentAndEmpDetails(Long deptId);

}
