package com.study.mongo.controller;

import com.study.mongo.entity.Student;
import com.study.mongo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @PostMapping("/save")
    public Student saveStudent(@RequestBody Student student){
        return studentService.StudentController(student);
    }

    @GetMapping("/get/{id}")
    public Student getStudentById(@PathVariable String id){
        return studentService.getStudentById(id);
    }

    @GetMapping("/get/all")
    public List<Student> getStudentByAll(){
        return studentService.getStudentByAll();
    }

    @PutMapping("/update")
    public Student updateStudent(@RequestBody Student student){
        return studentService.updateStudent(student);
    }
}
