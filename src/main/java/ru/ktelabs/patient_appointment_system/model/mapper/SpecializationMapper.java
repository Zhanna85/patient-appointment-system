package ru.ktelabs.patient_appointment_system.model.mapper;

import ru.ktelabs.patient_appointment_system.model.Specialization;
import ru.ktelabs.patient_appointment_system.model.dto.SpecializationDto;

public class SpecializationMapper {

    private SpecializationMapper() {
        //Экземпляр этого класса не может быть создан
    }

    public static Specialization toSpecialization(SpecializationDto dto) {
        Specialization specialization = new Specialization();
        specialization.setName(dto.getName());
        return specialization;
    }

    public static SpecializationDto toSpecializationDto(Specialization specialization) {
        return new SpecializationDto(specialization.getId(),
                                     specialization.getName());
    }
}