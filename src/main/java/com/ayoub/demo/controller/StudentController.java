package com.ayoub.demo.controller;

import com.ayoub.demo.entities.Student;
import com.ayoub.demo.dao.StudentDAO;
import com.ayoub.demo.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.*;


import java.util.ArrayList;
import java.util.List;

@RequestMapping("ayoubAppStudent")
@RestController
@CrossOrigin("*")
@Api(value = "ayoubAppStudent", description = "Handles Student transactions")
public class StudentController {

//    @Autowired
//    private StudentDAO studentDAO;
    @Autowired
    private StudentService studentService;

    private List<Student> students = new ArrayList<Student>(){};

    @GetMapping("addStudents")
    @ApiOperation(value = "adds some students")
    public void addStudents(){
        studentService.addSomeStudents();
    }

    @PostMapping("/{idStudent}/addCoursesToStudent")
    @ApiOperation(value = "adds some courses to students by student ID")
    public void addCoursesToStudentById(@PathVariable Long idStudent){
        studentService.addCoursesToStudentById(idStudent);
    }

    @GetMapping("getAllStudents")
    @ApiOperation(value = "returns list of all students")
    public List<Student> getStudents() throws SQLException {
            return studentService.getAllStudents();
    }


    @PostMapping("/{idStudent}/student")
    @ApiOperation(value = "finds a student by his ID")
    public HttpEntity<Student> getStudentById
            (@PathVariable Long idStudent){
        return studentService.getStudentById(idStudent);
    }

    @PostMapping("/{nameStudent}/names")
    @ApiOperation(value = "finds a student by his name")
    public  List<Student> getStudentsByName
            (@PathVariable String nameStudent){
        return studentService.getStudentsByName(nameStudent);
    }

}




   /* ---------------------------------- Junk functions ------------------------------------

        Connection conn = DriverManager.getConnection ("jdbc:h2:mem:testdb", "sa","");
        String sql = "SELECT * FROM student";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while(rs.next()) {
            Retrieve by column name
            Student s=new Student();
            s.setId(rs.getLong("id"));
            s.setName(rs.getString("name"));
            s.setPassportNumber(rs.getString("passport_number"));
            students.add(s);
      }
   -------------------------------------------------------------------------------------------*/
