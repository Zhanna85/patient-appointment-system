package ru.ktelabs.patient_appointment_system.service;

import ru.ktelabs.patient_appointment_system.model.dto.NewPatientDto;
import ru.ktelabs.patient_appointment_system.model.dto.PatientDto;

public interface PatientService {

    PatientDto creatPatient(NewPatientDto dto);

    PatientDto updatePatient(Long id, NewPatientDto dto);

    PatientDto getPatient(Long id);
}