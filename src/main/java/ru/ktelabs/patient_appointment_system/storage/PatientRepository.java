package ru.ktelabs.patient_appointment_system.storage;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ktelabs.patient_appointment_system.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
