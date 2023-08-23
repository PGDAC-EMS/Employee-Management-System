package com.app.service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
//import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.AnnouncementDTO;
import com.app.dto.AnnouncementWithoutDepartmentsDTO;
import com.app.dto.DepartmentDTO;
import com.app.dto.DepartmentEmpsDTO;
import com.app.entities.Announcement;
import com.app.entities.Department;
import com.app.exception.ResourceNotFoundException;
import com.app.repository.AnnouncementRepository;
import com.app.repository.DepartmentRepo;

@Service
public class AnnouncementServiceImpl implements AnnouncementService {
	
	private ModelMapper modelMapper;
    private AnnouncementRepository announcementRepository;
    private DepartmentService departmentService;

    @Autowired
    public AnnouncementServiceImpl(AnnouncementRepository announcementRepository, DepartmentService departmentService) {
        this.announcementRepository = announcementRepository;
        this.departmentService = departmentService;
        this.modelMapper = modelMapper;
    }

    @Override
    public Announcement createAnnouncement(AnnouncementDTO announcementDTO) {
        Announcement announcement = new Announcement();
        announcement.setTitle(announcementDTO.getTitle());
        announcement.setContent(announcementDTO.getContent());
        announcement.setExpiryDate(announcementDTO.getExpiryDate());

        List<Department> departments = new ArrayList<>();
        for (Long departmentId : announcementDTO.getDepartmentIds()) {
            DepartmentDTO departmentDTO = departmentService.getDepartmentDetails(departmentId);// Adjust this method name
            if (departmentDTO != null) {
                Department department = new Department();
                department.setId(departmentDTO.getId()); // Assuming you have an id field in Department
                departments.add(department);
            }
        }
        announcement.setDepartments(departments);

        return announcementRepository.save(announcement);
    }

    @Override
    public List<AnnouncementWithoutDepartmentsDTO> getAnnouncementsByDepartment(Long departmentId) {
    	LocalDate currentDate = LocalDate.now();
        List<Announcement> announcements = announcementRepository.findByDepartments_IdAndExpiryDateAfter(departmentId, currentDate);
        return announcements.stream()
            .map(this::convertToAnnouncementWithoutDepartmentsDTO)
            .collect(Collectors.toList());
    }
    public AnnouncementDTO convertToAnnouncementDTO(Announcement announcement) {
        return modelMapper.map(announcement, AnnouncementDTO.class);
    }
    
    @Override
    public List<AnnouncementWithoutDepartmentsDTO> getAllAnnouncementDTOs() {
        List<Announcement> announcements = announcementRepository.findAll();
        return announcements.stream()
            .map(this::convertToAnnouncementWithoutDepartmentsDTO)
            .collect(Collectors.toList());
    }
    private AnnouncementWithoutDepartmentsDTO convertToAnnouncementWithoutDepartmentsDTO(Announcement announcement) {
        AnnouncementWithoutDepartmentsDTO dto = new AnnouncementWithoutDepartmentsDTO();
        dto.setId(announcement.getId());
        dto.setTitle(announcement.getTitle());
        dto.setContent(announcement.getContent());
        dto.setExpiryDate(announcement.getExpiryDate());
        return dto;
    }
    
    @Override
    public AnnouncementDTO getAnnouncementById(Long announcementId) {
        Announcement announcement = announcementRepository.findById(announcementId)
            .orElseThrow(() -> new EntityNotFoundException("Announcement not found with id: " + announcementId));

        return convertToAnnouncementDTO(announcement);
    }


    @Override
    public List<Announcement> getAllAnnouncements() {
        return announcementRepository.findAll();
    }
    
    @Override
    public void deleteAnnouncementById(Long announcementId) {
        announcementRepository.deleteById(announcementId);
    }
}