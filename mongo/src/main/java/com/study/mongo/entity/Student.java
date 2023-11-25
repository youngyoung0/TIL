package com.study.mongo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "student")
public class Student {

    @Id
    private String id;
    private String name;
    @Field(name = "mail")
    private String email;
    private Department department;
    private List<Subject> subjects;

    @PersistenceCreator
    public Student(String id, String name, String email, Department department, List<Subject> subjects) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.department = department;
        this.subjects = subjects;
    }

    public Student(String id, Department department) {
        this.id = id;
        this.department = department;
    }
}
