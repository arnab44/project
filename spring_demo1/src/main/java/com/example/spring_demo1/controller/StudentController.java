package com.example.spring_demo1.controller;

import com.example.spring_demo1.model.Student;
import com.example.spring_demo1.model.StudentDTO;
import com.example.spring_demo1.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    StudentService studentService;

    @RequestMapping("/all")
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @RequestMapping("/{id}")
    public StudentDTO getStudents( @PathVariable(value = "id") int id) throws Exception {
        return studentService.topicEnrolled(id);
    }
}
