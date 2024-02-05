package ru.ktelabs.patient_appointment_system.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;

import static ru.ktelabs.patient_appointment_system.util.Constants.PATTERN_DATE;

public class NewPatientDto extends NewUserDto{

    @Past
    @JsonFormat(pattern = PATTERN_DATE)
    private LocalDate dateOfBirth; // дата рождения

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public String toString() {
        return "NewPatientDto{" +
                "name='" + name +
                ", dateOfBirth=" + dateOfBirth + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}