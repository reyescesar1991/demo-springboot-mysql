package com.example.demo.school;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class SchoolService {

    private final SchoolRepository schoolRepository;
    private final SchoolMapper schoolMapper;

    public SchoolService(SchoolRepository schoolRepository, SchoolMapper schoolMapper) {
        this.schoolRepository = schoolRepository;
        this.schoolMapper = schoolMapper;
    }

    public SchoolDto createSchool(SchoolDto dto) {

        var school = schoolMapper.toSchool(dto);
        schoolRepository.save(school);
        return dto;
    }

    public List<SchoolDto> findAll() {
        return schoolRepository.findAll().stream() //stream de School a SchoolDto
                .map(schoolMapper::toSchoolDto) //map to SchoolDto
                .toList(); //collect to List
    }
}
