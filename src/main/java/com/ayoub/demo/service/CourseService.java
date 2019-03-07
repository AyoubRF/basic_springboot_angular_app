package com.ayoub.demo.service;

import com.ayoub.demo.entities.Course;
import com.ayoub.demo.entities.Student;
import com.ayoub.demo.dao.CourseDAO;
import com.ayoub.demo.dao.StudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    CourseDAO courseDAO;

    @Autowired
    StudentDAO studentDAO;

    public List<Course> getCoursesByStudentId(@PathVariable Long studentId){
        Student student = studentDAO.findStudentById(studentId);
        return courseDAO.findByStudent(student);
    }

}