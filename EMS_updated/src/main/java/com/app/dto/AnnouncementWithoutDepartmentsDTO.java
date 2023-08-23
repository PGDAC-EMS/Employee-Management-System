package com.app.dto;

import java.time.LocalDate;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import lombok.*;


@Getter
@Setter
public class AnnouncementWithoutDepartmentsDTO {
    private Long id;
    private String title;
    private String content;
    private LocalDate expiryDate;
}