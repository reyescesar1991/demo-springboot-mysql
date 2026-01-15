package com.example.demo.student;

import org.springframework.stereotype.Service;

import com.example.demo.school.School;

@Service
public class StudentMapper {

    public Student toStudent(StudentDto studentDto) {

        if(studentDto == null){
            throw new NullPointerException("studentDto is null");
        }

        var student = new Student();
        student.setFirstName(studentDto.firstName());
        student.setLastName(studentDto.lastName());
        student.setEmail(studentDto.email());

        if (studentDto.schoolId() != null) {
            var school = new School();
            school.setId(studentDto.schoolId());
            student.setSchool(school);
        }

        return student;
    }

    public StudentResponseDto toStudentResponseDto(Student student) {
        return new StudentResponseDto(
                student.getFirstName(),
                student.getLastName(),
                student.getEmail()
        );
    }
}
