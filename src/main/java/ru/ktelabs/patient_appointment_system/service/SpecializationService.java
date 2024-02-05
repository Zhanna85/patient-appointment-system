package ru.ktelabs.patient_appointment_system.service;

import ru.ktelabs.patient_appointment_system.model.dto.SpecializationDto;

import java.util.Collection;

public interface SpecializationService {

    SpecializationDto creatSpecialization(SpecializationDto dto);

    SpecializationDto updateSpecialization(Long id, SpecializationDto dto);

    void deleteSpecialization(Long id);

    Collection<SpecializationDto> getAllSpecialization(Integer from, Integer size);
}