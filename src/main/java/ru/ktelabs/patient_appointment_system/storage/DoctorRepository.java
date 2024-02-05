package ru.ktelabs.patient_appointment_system.storage;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.ktelabs.patient_appointment_system.model.Doctor;

import java.util.List;
import java.util.Set;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    @Query(
            "select d " +
                    "from Doctor AS d " +
                    "JOIN FETCH d.specialties " +
                    "where (:text is null or (upper(d.name) like upper(concat('%', :text, '%')))) " +
                    "and (:ids is null or d.id in :ids)"
    )
    List<Doctor> search(String text, Set<Long> ids, PageRequest pageable);
}