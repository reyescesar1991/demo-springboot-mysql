package com.example.demo.student;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


//Segundo parametro es del tipo de dato que estamos manejando para el ID
public interface StudentRepository extends JpaRepository<Student, Integer> {

    //Query method: Debe tener el mismo nombre que la propiedad del entity
    List<Student> findStudentByFirstName(String firstName);
}
