package com.ayoub.demo.service;


import com.ayoub.demo.dao.CourseDAO;
import com.ayoub.demo.entities.Course;
import com.ayoub.demo.entities.Student;
import com.ayoub.demo.dao.StudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class StudentService {

    @Autowired
    StudentDAO studentDAO;

    @Autowired
    CourseDAO courseDAO;


    public List<Student> getAllStudents() throws SQLException {
        return studentDAO.findAll().stream().collect(Collectors.toList());
    }

    public void addSomeStudents() {

        studentDAO.save(new Student(null, "Ayoub", "55ABD", new ArrayList<>()));
        studentDAO.save(new Student(null, "Ali", "78C8D", new ArrayList<>()));
        studentDAO.save(new Student(null, "Ayoub", "DZ56d4", new ArrayList<>()));
        studentDAO.save(new Student(null, "Mohammed", "EE437M", new ArrayList<>()));

    }

    public void addCoursesToStudentById(Long studentId) {
        Student student = studentDAO.findStudentById(studentId);
        courseDAO.save(new Course(null,"Java",20,student));
        courseDAO.save(new Course(null,"Angular",18,student));

    }

    public HttpEntity<Student> getStudentById(Long idStudent) {
        Student student = studentDAO.findStudentById(idStudent);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    public List<Student> getStudentsByName(String nameStudent) {

        return studentDAO.findStudentByName(nameStudent);
    }
}
