package com.example.demo.student;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class StudentMapperTest {

    private StudentMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new StudentMapper();
    }

    @Test
    public void shouldMapStudentDtotoStudent(){
        StudentDto studentDto = new StudentDto("John", "Doe", "john.doe@example.com", 1);
        Student student = mapper.toStudent(studentDto);
        assertEquals(studentDto.firstName(), student.getFirstName());
        assertEquals(studentDto.lastName(), student.getLastName());
        assertEquals(studentDto.email(), student.getEmail());
        assertNotNull(student.getSchool());
        assertEquals(studentDto.schoolId(), student.getSchool().getId());
    }

    @Test
    public void shouldMapStudenttoStudentResponseDto(){
        Student student = new Student();
        student.setFirstName("Jane");
        student.setLastName("Doe");
        student.setEmail("jane.doe@example.com");
        StudentResponseDto studentResponseDto = mapper.toStudentResponseDto(student);
        assertEquals(student.getFirstName(), studentResponseDto.firstName());
        assertEquals(student.getLastName(), studentResponseDto.lastName());
        assertEquals(student.getEmail(), studentResponseDto.email());
    }

    @Test
    public void shouldThrowNullPointerExceptionWhenStudentDtoWhenStudentDtoIsNull(){
        
        var exp = assertThrows(NullPointerException.class, () -> {
            mapper.toStudent(null);
        });
        
        assertEquals("studentDto is null", exp.getMessage());
    }


    @BeforeAll
    static void initAll() {

        System.out.println("Before all tests executed");
    }

    @AfterEach
    void tearDown() {

        System.out.println("Teardown method executed");
    }

    @AfterAll
    static void tearDownAll() {

        System.out.println("After all tests executed");
    }

    @Test
    public void testMethod1(){

        System.out.println("Test method 1 executed");
    }
}