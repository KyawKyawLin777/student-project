package com.example.studentproject.service;

import com.example.studentproject.dao.*;
import com.example.studentproject.entity.Province;
import com.example.studentproject.entity.Student;
import com.example.studentproject.entity.StudentSubjects;
import com.example.studentproject.entity.Subjects;
import jakarta.persistence.EntityExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private ProvinceDao provinceDao;
    @Autowired
    private SubjectsDao subjectsDao;
    @Autowired
    private StudentSubjectsDao studentSubjectsDao;
    @Autowired
    private StudentDao studentDao;

    public Student findStudentByName(String name) {
        return studentDao.findStudentByName(name).orElseThrow(EntityExistsException::new);
    }


    public List<ProvinceDto> listProvinceInfo(){
        return studentSubjectsDao.findProvinceInfo();
    }

    public StudentDto findstudentDtoByMaxMarksInSubject(String subjectName){
        return studentSubjectsDao.findStudentInfoMaxMarks(subjectName)
                .orElseThrow(EntityExistsException::new);
    }

    public Iterable<StudentDto> listStudentInfo(){
        return studentSubjectsDao.findStudentInfo();
    }

    @Transactional
    public void createDb(){
        Province p1 = new Province();
        p1.setName("Sule");

        Province p2 = new Province();
        p2.setName("NO");

        Student s1 = new Student("Thaw Thaw",23,"Latha");
        Student s2 = new Student("John Doe",22,"ISM");
        Student s3 = new Student("John Kyaw",24,"PISM");
        Student s4 = new Student("Zaw Zaw",23,"ISY");

        Subjects subjects1 = new Subjects("Java","6 months",2000);
        Subjects subjects2 = new Subjects("Python","3 months",1500);
        Subjects subjects3 = new Subjects("Grovy","3 months",1000);

        //mapping
        p1.addStudent(s1);
        p1.addStudent(s2);
        p2.addStudent(s3);
        p2.addStudent(s4);

        StudentSubjects studentSubjects1 =new StudentSubjects();
        studentSubjects1.setMarks(95);


        StudentSubjects studentSubjects2 = new StudentSubjects();
        studentSubjects2.setMarks(70);
        StudentSubjects studentSubjectsManage2 = studentSubjectsDao.save(studentSubjects2);

        StudentSubjects studentSubjects3 = new StudentSubjects();
        studentSubjects3.setMarks(90);

        StudentSubjects studentSubjects4 = new StudentSubjects();
        studentSubjects4.setMarks(75);

        s1.addStudentSubjects(studentSubjectsDao.save(studentSubjects1));
        subjects1.addStudentSubjects(studentSubjectsDao.save(studentSubjects1));

        s1.addStudentSubjects(studentSubjects2);
        subjects2.addStudentSubjects(studentSubjects2);

        s2.addStudentSubjects(studentSubjectsDao.save(studentSubjects3));
        subjects1.addStudentSubjects(studentSubjectsDao.save(studentSubjects3));

        s3.addStudentSubjects(studentSubjectsDao.save(studentSubjects4));
        subjects3.addStudentSubjects(studentSubjectsDao.save(studentSubjects4));

        provinceDao.save(p1);
        provinceDao.save(p2);
        subjectsDao.save(subjects1);
        subjectsDao.save(subjects2);
        subjectsDao.save(subjects3);
    }
}
