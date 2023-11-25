package com.study.mongo.service;

import com.study.mongo.entity.Student;
import com.study.mongo.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public Student StudentController(Student student) {
        return studentRepository.save(student);
    }
}
