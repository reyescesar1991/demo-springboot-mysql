package com.example.demo;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.student.StudentDto;
import com.example.demo.student.StudentResponseDto;
import com.example.demo.student.StudentService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;

@RestController
public class FirstController {

    private final StudentService studentService;

    public FirstController(StudentService studentService) {
        this.studentService = studentService;
    }

    //No se pueden crear dos metodos con el mismo path y verbo HTTP
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello from Spring Boot!";
    }

    @GetMapping("/students")
    public List<StudentResponseDto> findStudents() {
        
        return this.studentService.findStudents();
    }

    //No se pueden crear dos metodos con el mismo path y verbo HTTP
    @GetMapping("/students/{student-id}")
    public StudentResponseDto findStudentById(@PathVariable("student-id") Integer studentId) {
        
        return this.studentService.findStudentById(studentId);
    }
    

    @PostMapping("/students")
    public StudentResponseDto saveStudent(@Valid @RequestBody StudentDto dto) {

        return this.studentService.saveStudent(dto);
    }


    @GetMapping("/students/search/{student-name}")
    public List<StudentResponseDto> findStudentsByFirstName(@PathVariable("student-name") String name) {
        
        return this.studentService.findStudentsByFirstName(name);
    }

    @DeleteMapping("/students/{student-id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String deleteStudent(@PathVariable("student-id") Integer studentId) {
        return this.studentService.deleteStudent(studentId);
    }

}
