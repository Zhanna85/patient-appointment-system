package ru.ktelabs.patient_appointment_system.model.dto;

import java.util.Set;

public class NewDoctorDto extends NewUserDto {

    private Set<Long> specialties; // Список идентификаторов специальностей;

    public Set<Long> getSpecialties() {
        return specialties;
    }

    @Override
    public String toString() {
        return "NewDoctorDto{" +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                "specialties=" + specialties +
                '}';
    }
}