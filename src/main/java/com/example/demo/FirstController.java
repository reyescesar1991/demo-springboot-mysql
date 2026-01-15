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
    public StudentResponseDto findStudentById(@PathVariable("student-id") Integer studentId) {
        return studentRepository.findById(studentId)
                .map(this::toStudentResponseDto)
                .orElse(null);
    }
    

    @PostMapping("/students")
    public StudentResponseDto post(@RequestBody StudentDto dto) {

        var student = toStudent(dto);
        var savedStudent = studentRepository.save(student);
        return toStudentResponseDto(savedStudent);
    }

    private Student toStudent(StudentDto studentDto) {
        var student = new Student();
        student.setFirstName(studentDto.firstName());
        student.setLastName(studentDto.lastName());
        student.setEmail(studentDto.email());

        var school = new School();
        school.setId(studentDto.schoolId());
        student.setSchool(school);

        return student;
    }

    private StudentResponseDto toStudentResponseDto(Student student) {
        return new StudentResponseDto(
                student.getFirstName(),
                student.getLastName(),
                student.getEmail()
        );
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
