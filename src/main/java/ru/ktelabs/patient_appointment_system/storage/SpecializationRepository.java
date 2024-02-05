package ru.ktelabs.patient_appointment_system.storage;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ktelabs.patient_appointment_system.model.Specialization;

public interface SpecializationRepository extends JpaRepository<Specialization, Long> {
}