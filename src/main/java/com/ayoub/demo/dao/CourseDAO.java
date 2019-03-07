package com.ayoub.demo.dao;

import com.ayoub.demo.entities.Course;
import com.ayoub.demo.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseDAO extends JpaRepository<Course,Long> {

    List<Course> findByStudent(Student student);

}
