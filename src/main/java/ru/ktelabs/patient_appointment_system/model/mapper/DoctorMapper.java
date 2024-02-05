package ru.ktelabs.patient_appointment_system.model.mapper;

import ru.ktelabs.patient_appointment_system.model.Doctor;
import ru.ktelabs.patient_appointment_system.model.dto.DoctorDto;
import ru.ktelabs.patient_appointment_system.model.dto.NewDoctorDto;

import java.util.stream.Collectors;

public class DoctorMapper {

    private DoctorMapper() {
    }

    public static Doctor toDoctor(NewDoctorDto dto) {
        Doctor newDoctor = new Doctor();
        newDoctor.setName(dto.getName());
        newDoctor.setPhoneNumber(dto.getPhoneNumber());
        newDoctor.setEmail(dto.getEmail());

        return newDoctor;
    }

    public static DoctorDto toDoctorDto(Doctor doctor) {
        DoctorDto dto = new DoctorDto();
        dto.setId(doctor.getId());
        dto.setUuid(doctor.getUuid());
        dto.setName(doctor.getName());
        dto.setPhoneNumber(doctor.getPhoneNumber());
        dto.setEmail(doctor.getEmail());
        dto.setCreated(doctor.getCreated());

        if (doctor.getSpecialties() != null) {
            dto.setSpecialties(doctor.getSpecialties().stream()
                    .map(SpecializationMapper::toSpecializationDto)
                    .collect(Collectors.toList()));
        }

        return dto;
    }
}