package ru.ktelabs.patient_appointment_system.service.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ktelabs.patient_appointment_system.controller.AdminDoctorController;
import ru.ktelabs.patient_appointment_system.exception.NotFoundException;
import ru.ktelabs.patient_appointment_system.model.Patient;
import ru.ktelabs.patient_appointment_system.model.TimeSlot;
import ru.ktelabs.patient_appointment_system.model.dto.TimeSlotDto;
import ru.ktelabs.patient_appointment_system.model.dto.TimeSlotDtoEnd;
import ru.ktelabs.patient_appointment_system.model.mapper.TimeSlotMapper;
import ru.ktelabs.patient_appointment_system.service.TimeSlotRestService;
import ru.ktelabs.patient_appointment_system.storage.PatientRepository;
import ru.ktelabs.patient_appointment_system.storage.TimeSlotRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static ru.ktelabs.patient_appointment_system.util.Messages.UPDATE_MODEL;

@Service
@Transactional(readOnly = true)
public class TimeSlotRestServiceImpl implements TimeSlotRestService {

    private final static Logger log = LoggerFactory.getLogger(AdminDoctorController.class);
    private final TimeSlotRepository repository;
    private final PatientRepository patientRepository;

    private Patient findByIdPatient(Long id) { // проверяем есть ли пациент с таким id
        return patientRepository.findById(id).orElseThrow(() -> new NotFoundException("Patient with id = " + id
                + " was not found"));
    }

    private TimeSlot findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Time slot with id = " + id
                + " was not found"));
    }

    public TimeSlotRestServiceImpl(TimeSlotRepository repository, PatientRepository patientRepository) {
        this.repository = repository;
        this.patientRepository = patientRepository;
    }


    @Override
    public List<TimeSlotDtoEnd> getFreeTimeSlots(Long idDoctor, LocalDate date) {
        return repository.findByDoctorIdAndReceptionDateAndPatientIdIsNull(idDoctor, date).stream()
                .map(TimeSlotMapper::toTimeSlotDtoEnd)
                .collect(Collectors.toList());
    }

    @Override
    public TimeSlotDto saveTimeSlotById(Long id, Long idPatient) {
        TimeSlot timeSlot = findById(id);
        Patient patient = findByIdPatient(idPatient);
        timeSlot.setPatient(patient);
        timeSlot.setLastUpdate(LocalDateTime.now());
        log.info(UPDATE_MODEL.getMessage(), timeSlot);
        return TimeSlotMapper.toTimeSlotDto(timeSlot);
    }

    @Override
    public List<TimeSlotDto> getSlotsTimeByIdPatient(Long idPatient) {
        return repository.findAllByPatientId(idPatient).stream()
                .map(TimeSlotMapper::toTimeSlotDto)
                .collect(Collectors.toList());
    }
}