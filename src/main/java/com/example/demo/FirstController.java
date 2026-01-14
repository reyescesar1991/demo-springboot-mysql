package com.example.demo;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

@RestController
public class FirstController {

    private final StudentRepository studentRepository;

    public FirstController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    //No se pueden crear dos metodos con el mismo path y verbo HTTP
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello from Spring Boot!";
    }

    @GetMapping("/students")
    public List<Student> findStudents() {
        return studentRepository.findAll();
    }

    //No se pueden crear dos metodos con el mismo path y verbo HTTP
    @GetMapping("/students/{student-id}")
    public String findStudentById(@PathVariable("student-id") Integer studentId) {
        return studentRepository.findById(studentId)
                .map(student -> "Student found: " + student.getFirstName() + " " + student.getLastName())
                .orElse("Student not found");
    }
    

    @PostMapping("/students")
    public String post(@RequestBody Student student) {


        studentRepository.save(student);
        return "Student added successfully!";
    }

    @GetMapping("/students/search/{student-name}")
    public List<Student> findStudentsByFirstName(@PathVariable("student-name") String name) {
        return studentRepository.findStudentByFirstName(name);
    }

    @DeleteMapping("/students/{student-id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String deleteStudent(@PathVariable("student-id") Integer studentId) {
        studentRepository.deleteById(studentId);
        return "Student deleted successfully!";
    }

}
