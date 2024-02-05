package ru.ktelabs.patient_appointment_system.model.dto;


import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class DoctorDto extends UserDto{

    private List<SpecializationDto> specialties; // специальности

    public DoctorDto() {

    }

    public DoctorDto(Long id, UUID uuid, String name, String phoneNumber, String email, LocalDateTime created,
                     List<SpecializationDto> specialties) {
        super(id, uuid, name, phoneNumber, email, created);
        this.specialties = specialties;
    }

    public List<SpecializationDto> getSpecialties() {
        return specialties;
    }

    public void setSpecialties(List<SpecializationDto> specialties) {
        this.specialties = specialties;
    }

    @Override
    public String toString() {
        return "DoctorDto{" +
                ", id=" + id +
                ", uuid=" + uuid +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", created=" + created +
                ", specialties=" + specialties +
                '}';
    }
}