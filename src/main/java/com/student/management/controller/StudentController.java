package com.student.management.controller;

import com.student.management.dto.StudentDto;
import com.student.management.pojo.StudentInfo;
import com.student.management.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/studentService")
public class StudentController {

    public StudentController(StudentService service) {
        this.service = service;
    }

    private StudentService service;

    @GetMapping("/getAllStudents")
    public String getAllStudents(Model model){
        model.addAttribute("students",service.getAllStudent());
        return "Student_Main";
    }

    //handler method to handel new student method
    @GetMapping("/NewStudent")
    public String newStudent(Model model){
        //model.addAttribute("students",);
        StudentDto studentDto = new StudentDto();
        model.addAttribute("student",studentDto);
        return "create_student";
    }

    @PostMapping("/createStudent")
    public String createStudent(@Valid  @ModelAttribute("student") StudentDto studentDto, BindingResult bindingResult,
                                Model model){
        //model.addAttribute("students",);
        if(bindingResult.hasErrors()){
            model.addAttribute("student",studentDto);
            return "create_student";
        }
        service.createStudentInfo(studentDto);
        return "redirect:/studentService/getAllStudents";
    }

    @GetMapping("/getStudent/{studentId}/edit")
    public String editStudent(@PathVariable("studentId") Long studentId, Model model){
        StudentDto studentDto =  service.getStudentById(studentId);
        model.addAttribute("student",studentDto);
        return "update_student";
    }

    @PostMapping("/updateStudent/{studentId}")
    public String editStudentRequest(@PathVariable("studentId") Long studentId, @Valid @ModelAttribute StudentDto studentDto,
    BindingResult bindingResult,Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("student",studentDto);
            return "update_student";
        }

        StudentDto updatedStudentInfo = service.updateStudent(studentDto);
        return "redirect:/studentService/getAllStudents";
    }

    @GetMapping("/getStudent/{studentId}/delete")
    public String deleteStudentById(@PathVariable("studentId") Long studentId){
        service.deleteStudentById(studentId);
        return "redirect:/studentService/getAllStudents";
    }

    @GetMapping("/getStudent/{studentId}/view")
    public String viewStudent(@PathVariable("studentId") Long studentId, Model model){
        StudentDto studentDto =  service.getStudentById(studentId);
        model.addAttribute("student",studentDto);
        return "view_student";
    }

}
