package com.app.repository;


import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.entities.Announcement;

@Repository
public interface AnnouncementRepository extends JpaRepository<Announcement, Long> {
	List<Announcement> findByDepartments_IdAndExpiryDateAfter(Long departmentId, LocalDate currentDate);
//    
    @Query("SELECT a FROM Announcement a JOIN FETCH a.departments d WHERE d.id = :departmentId AND a.expiryDate > :currentDate")
    List<Announcement> findAnnouncementsByDepartmentId(@Param("departmentId") Long departmentId, @Param("currentDate") LocalDate currentDate);
}