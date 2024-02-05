package ru.ktelabs.patient_appointment_system.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class SpecializationDto {

    private Long id;

    @NotBlank
    @Size(min = 3, max = 255)
    private String name;

    public SpecializationDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "SpecializationDto {" +
                "id = " + id +
                ", name = '" + name + '\'' +
                '}';
    }
}