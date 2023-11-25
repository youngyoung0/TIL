package com.study.mongo.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
public class Subject {
    @Field(name = "subject_name")
    private String subjectName;
    @Field(name = "marks_obtained")
    private Integer marksObtained;
}
