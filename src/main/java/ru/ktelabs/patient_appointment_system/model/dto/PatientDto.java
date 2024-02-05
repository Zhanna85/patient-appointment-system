package ru.ktelabs.patient_appointment_system.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import static ru.ktelabs.patient_appointment_system.util.Constants.PATTERN_DATE;

public class PatientDto extends UserDto{

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = PATTERN_DATE)
    private LocalDate dateOfBirth; // дата рождения

    public PatientDto() {
    }

    public PatientDto(Long id, UUID uuid, String name, String phoneNumber, String email, LocalDateTime created) {
        super(id, uuid, name, phoneNumber, email, created);
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "PatientDto{" +
                ", id=" + id +
                ", uuid=" + uuid +
                ", name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", created=" + created +
                '}';
    }
}
