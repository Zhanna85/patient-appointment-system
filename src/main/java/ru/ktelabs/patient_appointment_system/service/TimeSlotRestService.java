package ru.ktelabs.patient_appointment_system.service;

import ru.ktelabs.patient_appointment_system.model.dto.TimeSlotDto;
import ru.ktelabs.patient_appointment_system.model.dto.TimeSlotDtoEnd;

import java.time.LocalDate;
import java.util.List;

public interface TimeSlotRestService {

    //Получение свободных слотов времени к указанному врачу на указанную дату
    List<TimeSlotDtoEnd> getFreeTimeSlots(Long idDoctor, LocalDate date);

    //Занятие слота времени по его id
    TimeSlotDto saveTimeSlotById(Long id, Long idPatient);

    //Получение всех слотов времени, занятых одним пациентом по id/uuid
    List<TimeSlotDto> getSlotsTimeByIdPatient(Long idPatient);
}