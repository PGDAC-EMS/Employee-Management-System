package com.app.service;

import java.util.List;

import com.app.dto.AnnouncementDTO;
import com.app.dto.AnnouncementWithoutDepartmentsDTO;
import com.app.entities.Announcement;

public interface AnnouncementService {
    Announcement createAnnouncement(AnnouncementDTO announcementDTO);
    List<Announcement> getAllAnnouncements();
    List<AnnouncementWithoutDepartmentsDTO> getAnnouncementsByDepartment(Long departmentId);
	List<AnnouncementWithoutDepartmentsDTO> getAllAnnouncementDTOs();
	void deleteAnnouncementById(Long announcementId);
	AnnouncementDTO getAnnouncementById(Long announcementId);
	AnnouncementDTO convertToAnnouncementDTO(Announcement announcement);
}