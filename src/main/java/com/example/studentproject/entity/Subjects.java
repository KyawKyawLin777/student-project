package com.example.studentproject.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "subjects")
public class Subjects {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subjects_id")
    private Integer id;
    private String name;
    private String duration;
    private int price;
    @OneToMany(mappedBy = "subjects",cascade = CascadeType.PERSIST)
    private List<StudentSubjects> studentSubjectss = new ArrayList<>();

    public Subjects(){

    }

    public Subjects(String name, String duration, int price) {
        this.name = name;
        this.duration = duration;
        this.price = price;
    }
    public void addStudentSubjects(StudentSubjects studentSubjects){
        studentSubjects.setSubjects(this);
        studentSubjectss.add(studentSubjects);
    }
}
