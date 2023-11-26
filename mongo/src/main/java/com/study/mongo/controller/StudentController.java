package com.study.mongo.controller;

import com.study.mongo.entity.Student;
import com.study.mongo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
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

    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable String id){
        return studentService.deleteStudent(id);
    }

    @GetMapping("/get/name/{name}")
    public List<Student> getStudentsByName(@PathVariable String name){
        return studentService.getStudentsByName(name);
    }

    @GetMapping("/get/studentByNameAndMail")
    public List<Student> getStudentByNameAndMail(@RequestParam String name, @RequestParam String email){
        return studentService.getStudentsByNameAndMail(name, email);
    }

    @GetMapping("/get/studentByNameOrMail")
    public List<Student> getStudentByNameOrMail(@RequestParam String name, @RequestParam String email){
        return studentService.getStudentsByNameOrMail(name, email);
    }

    @GetMapping("/allWithPagination")
    public Page<Student> getAllWithPagination(@RequestParam int pageNo, @RequestParam int pageSize){
        return studentService.getAllWithPagination(pageNo, pageSize);
    }
}
