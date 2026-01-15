package com.example.demo;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class SchoolController {

    private final SchoolRepository schoolRepository;

    public SchoolController(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    @PostMapping("/schools")
    public SchoolDto createSchool(@RequestBody SchoolDto dto) {

        var school = toSchool(dto);
        schoolRepository.save(school);
        return dto;
    }

    private School toSchool(SchoolDto schoolDto) {
        return new School(schoolDto.name());
    }

    private SchoolDto toSchoolDto(School school) {
        return new SchoolDto(school.getName());
    }

    @GetMapping("/schools")
    public List<SchoolDto> findAll() {
        return schoolRepository.findAll().stream() //stream de School a SchoolDto
                .map(this::toSchoolDto) //map to SchoolDto
                .toList(); //collect to List
    }
    
}
