package ru.ktelabs.patient_appointment_system.service.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ktelabs.patient_appointment_system.model.Doctor;
import ru.ktelabs.patient_appointment_system.model.TimeSlot;
import ru.ktelabs.patient_appointment_system.model.dto.TimeSlotDtoEnd;
import ru.ktelabs.patient_appointment_system.model.mapper.TimeSlotMapper;
import ru.ktelabs.patient_appointment_system.storage.DoctorRepository;
import ru.ktelabs.patient_appointment_system.storage.TimeSlotRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScheduleService {

    private final static Logger log = LoggerFactory.getLogger(ScheduleService.class);
    private final TimeSlotRepository scheduleRepository;
    private final DoctorRepository doctorRepository;

    public ScheduleService(TimeSlotRepository scheduleRepository, DoctorRepository doctorRepository) {
        this.scheduleRepository = scheduleRepository;
        this.doctorRepository = doctorRepository;
    }

    private Doctor findDoctorById(Long id) {
        return doctorRepository.findById(id).orElseThrow();
    }

    @Transactional
    public List<TimeSlotDtoEnd> createSchedule(LocalDate dateStart, // даты начала расписания
                                               LocalTime timeStart, // времени начала расписания
                                               Long duration, // продолжительность талона (слота времени)
                                               Integer countTicket, // количество
                                               Long idDoctor) {
        log.info("Create schedule. Parameters: date {}, time start {}, duration {}, count tickets {}, id doctor {}",
                dateStart, timeStart, duration, countTicket, idDoctor);
        Doctor doctor = findDoctorById(idDoctor);
        List<TimeSlot> schedules = new ArrayList<>();
        schedules.add(new TimeSlot(doctor, dateStart, timeStart));
        countTicket--;

        while (countTicket>0) {
            timeStart = timeStart.plusMinutes(duration);
            schedules.add(new TimeSlot(doctor, dateStart, timeStart));
            countTicket--;
        }

        log.info("Save schedule {}", schedules);
        return scheduleRepository.saveAll(schedules).stream()
                .map(TimeSlotMapper::toTimeSlotDtoEnd)
                .collect(Collectors.toList());
    }
}