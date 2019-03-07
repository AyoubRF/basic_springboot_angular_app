package com.ayoub.demo.dao;

import com.ayoub.demo.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentDAO extends JpaRepository<Student,Long > {

    Student findStudentById(Long studentId);
    List<Student> findStudentByName(String studentName);

}
