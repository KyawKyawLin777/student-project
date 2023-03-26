package com.example.studentproject.dao;

import com.example.studentproject.entity.Subjects;
import org.springframework.data.repository.CrudRepository;

public interface SubjectsDao extends CrudRepository<Subjects,Integer> {
}
