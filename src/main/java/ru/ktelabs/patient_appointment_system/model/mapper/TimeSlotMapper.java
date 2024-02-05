package ru.ktelabs.patient_appointment_system.model.mapper;

import ru.ktelabs.patient_appointment_system.model.TimeSlot;
import ru.ktelabs.patient_appointment_system.model.dto.TimeSlotDto;
import ru.ktelabs.patient_appointment_system.model.dto.TimeSlotDtoEnd;

public class TimeSlotMapper {

    private TimeSlotMapper() {
    }

    public static TimeSlotDto toTimeSlotDto(TimeSlot timeSlot) {
        return new TimeSlotDto(
                timeSlot.getId(),
                timeSlot.getDoctor().getId(),
                timeSlot.getPatient().getId(),
                timeSlot.getReceptionDate(),
                timeSlot.getReceptionStartTime(),
                timeSlot.getCreatedDate(),
                timeSlot.getLastUpdate()
                );
    }

    public static TimeSlotDtoEnd toTimeSlotDtoEnd(TimeSlot timeSlot) {
        return new TimeSlotDtoEnd(
                timeSlot.getId(),
                timeSlot.getDoctor().getId(),
                timeSlot.getReceptionDate(),
                timeSlot.getReceptionStartTime(),
                timeSlot.getCreatedDate()
        );
    }
}