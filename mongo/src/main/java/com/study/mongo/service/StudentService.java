package com.study.mongo.service;

import com.study.mongo.entity.Student;
import com.study.mongo.entity.type.Type;
import com.study.mongo.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    public List<Student> getAllWithPagination(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return studentRepository.findAll(pageable).getContent();

    }

    public List<Student> getAllWithSorting(Type type) {
        if(type.equals(Type.ASC)){
            Sort sort = Sort.by(Sort.Direction.ASC, "name");
            return studentRepository.findAll(sort);
        }else if(type.equals(Type.DESC)){
            Sort sort = Sort.by(Sort.Direction.DESC, "name");
            return studentRepository.findAll(sort);
        }
        throw new RuntimeException("존재하지 않는 정렬 방식입니다.");
    }

    public List<Student> byDepartmentName(String deptName) {
        return studentRepository.findByDepartmentDepartmentName(deptName);
    }
}
