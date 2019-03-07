package com.ayoub.demo.controller;

import com.ayoub.demo.entities.Course;
import com.ayoub.demo.dao.CourseDAO;
import com.ayoub.demo.dao.StudentDAO;
import com.ayoub.demo.service.CourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("ayoubAppCourse")
@RestController
@Api(value = "ayoubAppCourse", description = "Handles Courses transactions")
public class CourseController {

    @Autowired
    private StudentDAO studentDAO;

    @Autowired
    CourseService courseService;

    @Autowired
    private CourseDAO courseDAO;

    @PostMapping("/{studentId}/courses")
    @ApiOperation(value = "finds all student courses by student ID")
    public List<Course> getCoursesById(@PathVariable Long studentId){
        return courseService.getCoursesByStudentId(studentId);
    }



}
