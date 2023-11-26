package com.study.mongo.service;

import com.study.mongo.entity.Student;
import com.study.mongo.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    public List<Student> getStudentsByNameAndMail(String name, String email) {
        return studentRepository.findByNameAndEmail(name, email);
    }

    public List<Student> getStudentsByNameOrMail(String name, String email) {
        return studentRepository.findByNameOrEmail(name, email);
    }

    public Page<Student> getAllWithPagination(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return studentRepository.findAll(pageable);

    }
}
