package ru.ktelabs.patient_appointment_system.model.mapper;

import ru.ktelabs.patient_appointment_system.model.Doctor;
import ru.ktelabs.patient_appointment_system.model.Patient;
import ru.ktelabs.patient_appointment_system.model.dto.DoctorDto;
import ru.ktelabs.patient_appointment_system.model.dto.NewDoctorDto;
import ru.ktelabs.patient_appointment_system.model.dto.NewPatientDto;
import ru.ktelabs.patient_appointment_system.model.dto.PatientDto;

import java.util.stream.Collectors;

public class PatientMapper {

    public PatientMapper() {
    }

    public static Patient toNewPatient(NewPatientDto dto) {
        Patient newPatient = new Patient();
        newPatient.setName(dto.getName());
        newPatient.setPhoneNumber(dto.getPhoneNumber());
        newPatient.setEmail(dto.getEmail());
        newPatient.setDateOfBirth(dto.getDateOfBirth());

        return newPatient;
    }

    public static PatientDto toPatientDto(Patient patient) {
        PatientDto dto = new PatientDto();
        dto.setId(patient.getId());
        dto.setUuid(patient.getUuid());
        dto.setName(patient.getName());
        dto.setPhoneNumber(patient.getPhoneNumber());
        dto.setEmail(patient.getEmail());
        dto.setCreated(patient.getCreated());
        dto.setDateOfBirth(patient.getDateOfBirth());

        return dto;
    }
}
