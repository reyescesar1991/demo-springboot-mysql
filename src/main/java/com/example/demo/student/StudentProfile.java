package com.example.demo.student;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class StudentProfile {

    @Id
    @GeneratedValue
    private Integer id;

    private String bio;

    // Unidirectional One-to-One mapping
    @OneToOne
    @JoinColumn(name = "student_id")
    @JsonBackReference
    private Student student;

    public StudentProfile() {
    }

    public StudentProfile(Integer id, String bio) {
        this.id = id;
        this.bio = bio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

}
