package com.example.demo.student;

import jakarta.validation.constraints.NotEmpty;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;

public record StudentDto(

    @NotEmpty(message = "First name cannot be empty")
    String firstName,

    @NotEmpty(message = "Last name cannot be empty")
    String lastName,

    String email,

    Integer schoolId
) {
    @JsonCreator
    public StudentDto(
        @JsonProperty("firstName") String firstName,
        @JsonProperty("lastName") String lastName,
        @JsonProperty("email") String email,
        @JsonProperty("schoolId") Integer schoolId
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.schoolId = schoolId;
    }
}
