package com.example.studentproject;

import com.example.studentproject.dao.StudentDto;
import com.example.studentproject.entity.Student;
import com.example.studentproject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentProjectApplication implements CommandLineRunner {

    @Autowired
    private StudentService studentService;

    public static void main(String[] args) {
        SpringApplication.run(StudentProjectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        studentService.createDb();
        System.out.println("Student Info::");
        studentService.listStudentInfo().forEach(s -> {
            System.out.println(String.format("%s lives in %s got %s marks in subjects %s",
                    s.getStudentName(),
                    s.getProvincename(),
                    s.getMarks(),
                    s.getSubjectName()));
        });
        System.out.println();
        System.out.println("Max Marks in Subject");
        StudentDto studentDto = studentService.findstudentDtoByMaxMarksInSubject("Java");
        System.out.println(studentDto);

        System.out.println();
        System.out.println("Province Info::");
        studentService.listProvinceInfo().forEach(p-> {
            System.out.println(String.format("%s province lives in %s persons.",
                    p.provinceName(),
                    p.count()
                            ));
        });
        System.out.println();
        System.out.println("Student by Name NamedQuery");
        System.out.println(studentService.findStudentByName("John Kyaw"));

        JPAUtil.checkData("select * from province");
        JPAUtil.checkData("select * from student");
        JPAUtil.checkData("select * from student_subjects");
        JPAUtil.checkData("select * from subjects");
    }
}
