package com.study.mongo.service;

import com.study.mongo.entity.Student;
import com.study.mongo.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public Student StudentController(Student student) {
        return studentRepository.save(student);
    }

    public Student getStudentById(String id) {
        return studentRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("존재하지 않는 학생입니다."));
    }

    public List<Student> getStudentByAll() {
        return studentRepository.findAll();
    }

    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    public String deleteStudent(String id) {
        studentRepository.deleteById(id);
        return "delete has been student";
    }

    public List<Student> getStudentsByName(String name) {
        return studentRepository.findByName(name);
    }
}
