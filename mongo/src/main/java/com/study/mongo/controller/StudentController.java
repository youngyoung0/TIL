package com.study.mongo.controller;

import com.study.mongo.entity.Student;
import com.study.mongo.entity.type.Type;
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
    public List<Student> getAllWithPagination(@RequestParam int pageNo, @RequestParam int pageSize){
        return studentService.getAllWithPagination(pageNo, pageSize);
    }

    @GetMapping("/allWithSorting")
    public List<Student> getAllWithSorting(@RequestParam Type type){
        return studentService.getAllWithSorting(type);
    }

    @GetMapping("/get/department-name")
    public List<Student> byDepartmentName(@RequestParam String deptName){
        return studentService.byDepartmentName(deptName);
    }

    @GetMapping("/get/subject-name")
    public List<Student> bySubjectName(@RequestParam String subjectName){
        return studentService.bySubjectName(subjectName);
    }

    @GetMapping("/like/email")
    public List<Student> likeEmail(@RequestParam String email){
        return studentService.likeEmail(email);
    }

    @GetMapping("/name/starts/with")
    public List<Student> nameStartWith(@RequestParam String name){
        return studentService.nameStartWith(name);
    }
}
