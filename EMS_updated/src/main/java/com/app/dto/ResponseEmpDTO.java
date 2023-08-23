package com.app.dto;

import java.time.LocalDate;

//import javax.validation.constraints.NotBlank;

//import org.springframework.format.annotation.DateTimeFormat;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ResponseEmpDTO {
   private Long id;
   private String firstName;
   
   private String lastName;
   private String email;
   
   private String designation;
   private Long managerId;
   
   private LocalDate joinDate;
   
   private double salary;
   private String gender;
   
   private String contact;
   private LocalDate birthDate;
   
   private String address;

}
