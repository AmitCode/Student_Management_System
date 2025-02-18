package com.student.management.service;

import com.student.management.dto.StudentDto;

import java.util.List;

public interface StudentService {
    public List<StudentDto> getAllStudent();
    public StudentDto createStudentInfo(StudentDto studentDto);
    public StudentDto getStudentById(Long id);
    public StudentDto updateStudent(StudentDto studentDto);
    public void deleteStudentById(Long studentId);
}
