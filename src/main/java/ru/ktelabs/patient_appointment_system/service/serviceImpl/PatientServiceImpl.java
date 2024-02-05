package ru.ktelabs.patient_appointment_system.service.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ktelabs.patient_appointment_system.exception.NotFoundException;
import ru.ktelabs.patient_appointment_system.model.Patient;
import ru.ktelabs.patient_appointment_system.model.dto.NewPatientDto;
import ru.ktelabs.patient_appointment_system.model.dto.PatientDto;
import ru.ktelabs.patient_appointment_system.model.mapper.PatientMapper;
import ru.ktelabs.patient_appointment_system.service.PatientService;
import ru.ktelabs.patient_appointment_system.storage.PatientRepository;

import java.time.LocalDate;

import static ru.ktelabs.patient_appointment_system.util.Messages.*;

@Service
@Transactional(readOnly = true)
public class PatientServiceImpl implements PatientService {

    private final static Logger log = LoggerFactory.getLogger(PatientServiceImpl.class);
    private final PatientRepository repository;

    public PatientServiceImpl(PatientRepository repository) {
        this.repository = repository;
    }

    private Patient findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("User with id = " + id
                + " was not found"));
    }
    @Override
    public PatientDto creatPatient(NewPatientDto dto) {
        Patient patient = repository.save(PatientMapper.toNewPatient(dto));
        log.info(SAVE_MODEL.getMessage(), patient);
        return PatientMapper.toPatientDto(patient);
    }

    @Override
    public PatientDto updatePatient(Long id, NewPatientDto dto) {
        Patient patient = findById(id);
        String name = dto.getName();
        String phoneNumber = dto.getPhoneNumber();
        String email = dto.getEmail();
        LocalDate date = dto.getDateOfBirth();

        if (name != null) {
            patient.setName(name);
        }
        if (phoneNumber != null) {
            patient.setPhoneNumber(phoneNumber);
        }
        if (email != null) {
            patient.setEmail(email);
        }
        if (date != null) {
            patient.setDateOfBirth(dto.getDateOfBirth());
        }

        log.info(UPDATE_MODEL.getMessage(), patient);
        return PatientMapper.toPatientDto(patient);
    }

    @Override
    public PatientDto getPatient(Long id) {
        log.info(GET_MODEL_BY_ID.getMessage(), id);
        return PatientMapper.toPatientDto(findById(id));
    }
}