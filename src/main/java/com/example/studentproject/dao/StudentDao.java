package com.example.studentproject.dao;

import com.example.studentproject.entity.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface StudentDao extends CrudRepository<Student,Integer> {

    Optional<Student> findStudentByName(String name);
}
