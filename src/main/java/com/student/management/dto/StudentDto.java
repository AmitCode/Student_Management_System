package com.student.management.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {
    private Long studentId;
    @NotEmpty(message = "Student Name can't be empty")
    private String studentName;
    @NotEmpty(message = "Student Email can't be empty")
    @Email
    private String studentEmail;
    @NotEmpty(message = "Student DOB can't be empty")
    private String studentDob;
    @NotEmpty(message = "Student student can't be empty")
    private String studentAddress;
}
