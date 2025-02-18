package com.student.management.service.servicesImpl;

import com.student.management.dto.StudentDto;
import com.student.management.mapper.StudentMapper;
import com.student.management.pojo.StudentInfo;
import com.student.management.repository.StudentInfoRepository;
import com.student.management.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    private StudentInfoRepository repository;

    public StudentServiceImpl(StudentInfoRepository repository) {
        this.repository = repository;
    }

    public List<StudentDto> getAllStudent(){
        List<StudentInfo> studentInfoList = repository.findAll();
        List<StudentDto> studentList = studentInfoList.stream().map((studentInfo -> StudentMapper.mapTOStudentDto(studentInfo))).collect(Collectors.toList());
        return studentList;
    }

    public StudentDto createStudentInfo(StudentDto studentDto){
        StudentInfo studentInfo = repository.save(StudentMapper.mapToStudent(studentDto));
        return StudentMapper.mapTOStudentDto(studentInfo);
    }

    public StudentDto getStudentById(Long id){
        StudentInfo studentInfo = repository.findById(id).get();
        return StudentMapper.mapTOStudentDto(studentInfo);
    }

    public StudentDto updateStudent(StudentDto studentDto){
        StudentInfo studentInfo = repository.findById(studentDto.getStudentId()).get();
        studentInfo.setStudentEmail(studentDto.getStudentEmail());
        studentInfo.setStudentAddress(studentDto.getStudentAddress());
        studentInfo.setStudentDob(studentDto.getStudentDob());
        StudentInfo updatedStudentInfo = repository.save(studentInfo);
        return StudentMapper.mapTOStudentDto(updatedStudentInfo);
    }

    public void deleteStudentById(Long studentId){
        repository.deleteById(studentId);
    }
}
