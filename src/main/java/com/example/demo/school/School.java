package com.example.demo.school;


import java.util.List;

import com.example.demo.student.Student;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class School {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    // Bidirectional One-to-Many mapping
    @OneToMany(mappedBy = "school")
    @JsonManagedReference // To handle JSON serialization issues
    private List<Student> students;

    public School() {
    }

    public School(String name) {
        this.name = name;
    }

    public School(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }


}
