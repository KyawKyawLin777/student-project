package com.example.studentproject.dao;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class StudentDto {

    private String studentName;
    private String provincename;
    private String subjectName;
    private int marks;

    public StudentDto(String studentName, String provincename, String subjectName, int marks) {
        this.studentName = studentName;
        this.provincename = provincename;
        this.subjectName = subjectName;
        this.marks = marks;
    }
}
