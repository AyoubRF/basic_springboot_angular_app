package com.ayoub.demo.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Course {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "Course_Name")
    private String name;
    @Column(name = "Number_Of_Hours")
    private int number_of_hours;


    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "D_STUDENT_ID")
    private Student student;
}
// Insert INTO COURSE VALUES (1, 'java',18,1)