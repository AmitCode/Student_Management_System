package com.student.management.mapper;

import com.student.management.dto.StudentDto;
import com.student.management.pojo.StudentInfo;

public class StudentMapper {
    public static StudentDto mapTOStudentDto(StudentInfo studentInfo){
        StudentDto studentDto = new StudentDto();
        studentDto.setStudentId(studentInfo.getStudentId());
        studentDto.setStudentName(studentInfo.getStudentName());
        studentDto.setStudentEmail(studentInfo.getStudentEmail());
        studentDto.setStudentAddress(studentInfo.getStudentAddress());
        studentDto.setStudentDob(studentInfo.getStudentDob());
        return studentDto;
    }

    public static StudentInfo mapToStudent(StudentDto studentDto){
        StudentInfo studentInfo = new StudentInfo();
        studentInfo.setStudentId(studentDto.getStudentId());
        studentInfo.setStudentName(studentDto.getStudentName());
        studentInfo.setStudentEmail(studentDto.getStudentEmail());
        studentInfo.setStudentAddress(studentDto.getStudentAddress());
        studentInfo.setStudentDob(studentDto.getStudentDob());
        return studentInfo;
    }
}
