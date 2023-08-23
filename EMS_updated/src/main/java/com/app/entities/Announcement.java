package com.app.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(exclude="departments")
@Table(name="announcements")
public class Announcement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "title",length=30)
    private String title;
    @Column(name = "content",length=200)
    private String content;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate expiryDate;

    @ManyToMany
    @JoinTable(
        name = "announcement_department",
        joinColumns = @JoinColumn(name = "announcement_id"),
        inverseJoinColumns = @JoinColumn(name = "department_id")
    )
    private List<Department> departments;

    // Constructors, getters, and setters
}