package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AnnouncementDTO;
import com.app.dto.AnnouncementWithoutDepartmentsDTO;
import com.app.dto.ApiResponse;
import com.app.entities.Announcement;
import com.app.entities.Department;
import com.app.service.AnnouncementService;
import com.app.service.DepartmentService;

@RestController
@RequestMapping("/announcements")
public class AnnouncementController {

    private final AnnouncementService announcementService;
    private final DepartmentService departmentService;

    @Autowired
    public AnnouncementController(AnnouncementService announcementService, DepartmentService departmentService) {
        this.announcementService = announcementService;
        this.departmentService = departmentService;
    }

    @PostMapping
    public ResponseEntity<Announcement> createAnnouncement(@RequestBody AnnouncementDTO announcementDTO) {
        Announcement createdAnnouncement = announcementService.createAnnouncement(announcementDTO);
        return new ResponseEntity<>(createdAnnouncement, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AnnouncementWithoutDepartmentsDTO>> getAllAnnouncements() {
        List<AnnouncementWithoutDepartmentsDTO> announcementDTOs = announcementService.getAllAnnouncementDTOs();
        return ResponseEntity.ok(announcementDTOs);
    }
    @GetMapping("/byDepartment/{departmentId}")
    public ResponseEntity<List<AnnouncementWithoutDepartmentsDTO>> getAnnouncementsByDepartment(@PathVariable Long departmentId) {
        List<AnnouncementWithoutDepartmentsDTO> announcements = announcementService.getAnnouncementsByDepartment(departmentId);
        return ResponseEntity.ok(announcements);
    }
    
    @DeleteMapping("/{announcementId}")
    public ResponseEntity<ApiResponse> deleteAnnouncement(@PathVariable Long announcementId) {
        announcementService.deleteAnnouncementById(announcementId);
        return ResponseEntity.ok(new ApiResponse("Announcement deleted successfully."));
    }
}