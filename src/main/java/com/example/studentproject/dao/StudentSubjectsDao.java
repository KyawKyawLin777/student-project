package com.example.studentproject.dao;

import com.example.studentproject.entity.StudentSubjects;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface StudentSubjectsDao extends CrudRepository<StudentSubjects,Integer> {

    @Query("""
            select  new com.example.studentproject.dao.ProvinceDto(p.name,count(s))
            from Province p join p.students s group by p.name
            """)
    public List<ProvinceDto> findProvinceInfo();
    @Query("""
            select new com.example.studentproject.dao.StudentDto(s.name,p.name,sub.name,stusub.marks) 
            from Province p join p.students s join s.studentSubjectss stusub join stusub.subjects sub
            """)
    public Iterable<StudentDto> findStudentInfo();

    @Query("""
            select new com.example.studentproject.dao.StudentDto(s.name,p.name,sub.name,stusub.marks)
            from Province p join p.students s join s.studentSubjectss stusub join stusub.subjects sub
            where stusub.marks = (select max (sb.marks) from StudentSubjects sb) and sub.name =?1
            """)
    Optional<StudentDto> findStudentInfoMaxMarks(String subjectName);
}
