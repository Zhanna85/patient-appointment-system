package ru.ktelabs.patient_appointment_system.service;

import ru.ktelabs.patient_appointment_system.model.dto.DoctorDto;
import ru.ktelabs.patient_appointment_system.model.dto.NewDoctorDto;

import java.util.Collection;
import java.util.Set;

public interface DoctorService {
    DoctorDto creatDoctor(NewDoctorDto dto);

    DoctorDto updateDoctor(Long id, NewDoctorDto dto);

    void deleteDoctor(Long id);

    Collection<DoctorDto> getAllDoctor(String text,
                                       Set<Long> ids,
                                       Integer from,
                                       Integer size);
}