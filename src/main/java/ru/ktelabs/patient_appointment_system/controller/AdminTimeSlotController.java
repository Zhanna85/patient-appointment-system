package ru.ktelabs.patient_appointment_system.controller;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Positive;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.ktelabs.patient_appointment_system.model.dto.TimeSlotDto;
import ru.ktelabs.patient_appointment_system.model.dto.TimeSlotDtoEnd;
import ru.ktelabs.patient_appointment_system.service.TimeSlotRestService;

import java.time.LocalDate;
import java.util.Collection;

@RestController
@RequestMapping("/admin/schedule")
@Validated
public class AdminTimeSlotController {

    private final static Logger log = LoggerFactory.getLogger(AdminTimeSlotController.class);
    private final TimeSlotRestService service;

    public AdminTimeSlotController(TimeSlotRestService service) {
        this.service = service;
    }

    @GetMapping("/freeTimeSlot")
    public Collection<TimeSlotDtoEnd> getFreeTimeSlots(@RequestParam @Positive Long doctorId,
                                                       @RequestParam @FutureOrPresent LocalDate date) {
        log.info("Get free time slots by id doctor {} and date {}", doctorId, date);
        return service.getFreeTimeSlots(doctorId, date);
    }

    @PatchMapping("/{id}")
    public TimeSlotDto updateTimeSlotById(@PathVariable @Positive Long id,
                                          @RequestParam @Positive Long idPatient) {
        log.info("Update time slot by id {} and id patient {}", id, idPatient);
        return service.saveTimeSlotById(id, idPatient);
    }

    @GetMapping
    public Collection<TimeSlotDto> getTimeSlotsByIdPatient(@RequestParam @Positive Long idPatient) {
        log.info("Get time slots by id patient {}", idPatient);
        return service.getSlotsTimeByIdPatient(idPatient);
    }
}