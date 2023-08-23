package com.app.dto;

import java.time.LocalDate;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AnnouncementDTO {
    private String title;
    private String content;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate expiryDate;
    private List<Long> departmentIds;

    // Constructors, getters, and setters
}