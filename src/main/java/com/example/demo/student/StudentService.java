package com.example.demo.student;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentService(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    public StudentResponseDto saveStudent(StudentDto dto) {
        var student = studentMapper.toStudent(dto);
        var savedStudent = studentRepository.save(student);
        return studentMapper.toStudentResponseDto(savedStudent);
    }

    public StudentResponseDto findStudentById(Integer studentId) {
        return studentRepository.findById(studentId)
                .map(studentMapper::toStudentResponseDto)
                .orElse(null);
    }

    public List<StudentResponseDto> findStudents() {
        return studentRepository.findAll().stream()
                .map(studentMapper::toStudentResponseDto)
                .toList();
    }

    public List<StudentResponseDto> findStudentsByFirstName(@PathVariable("student-name") String name) {
        return studentRepository.findStudentByFirstName(name).stream()
                .map(studentMapper::toStudentResponseDto)
                .toList();
    }

    public String deleteStudent(@PathVariable("student-id") Integer studentId) {
        studentRepository.deleteById(studentId);
        return "Student deleted successfully!";
    }
}
