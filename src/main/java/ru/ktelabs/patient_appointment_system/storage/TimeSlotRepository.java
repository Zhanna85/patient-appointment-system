package ru.ktelabs.patient_appointment_system.storage;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ktelabs.patient_appointment_system.model.TimeSlot;

import java.time.LocalDate;
import java.util.List;

public interface TimeSlotRepository extends JpaRepository<TimeSlot, Long> {
    List<TimeSlot> findAllByPatientId(Long id);

    List<TimeSlot> findByDoctorIdAndReceptionDate(Long idDoctor, LocalDate date);
}