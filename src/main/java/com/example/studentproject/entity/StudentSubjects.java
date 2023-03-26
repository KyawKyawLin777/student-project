package com.example.studentproject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "student_subjects")
public class StudentSubjects {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_subjects_id")
    private Integer id;
    private int marks;
    @JoinColumn(name = "sub_id")
    @ManyToOne
    private Subjects subjects;
    @JoinColumn(name = "stu_id")
    @ManyToOne
    private Student student;
}
