package com.example.studentproject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "province")
public class Province {
    @Id
    @Column(name = "province_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToMany(mappedBy = "province",cascade = CascadeType.PERSIST)
    private List<Student> students = new ArrayList<>();

    public void addStudent(Student student){
        student.setProvince(this);
        students.add(student);
    }

}
