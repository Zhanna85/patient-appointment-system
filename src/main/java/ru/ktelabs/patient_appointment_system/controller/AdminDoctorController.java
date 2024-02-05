package ru.ktelabs.patient_appointment_system.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.ktelabs.patient_appointment_system.model.dto.DoctorDto;
import ru.ktelabs.patient_appointment_system.model.dto.NewDoctorDto;
import ru.ktelabs.patient_appointment_system.service.DoctorService;

import java.util.Collection;
import java.util.Set;

@RestController
@RequestMapping("/admin/doctors")
@Validated
public class AdminDoctorController {

    private final static Logger log = LoggerFactory.getLogger(AdminDoctorController.class);

    private final DoctorService service;


    public AdminDoctorController(DoctorService service) {
        this.service = service;
    }

    @PostMapping
    public DoctorDto saveDoctor(@Valid @RequestBody NewDoctorDto dto) {
        log.info("Creating {}", dto);
        return service.creatDoctor(dto);
    }

    @PatchMapping("/{doctorId}")
    public DoctorDto updateDoctor(@PathVariable(value = "doctorId") Long id,
                                  @Valid @RequestBody NewDoctorDto dto) {
        log.info("Updating {} by id {}", dto, id);
        return service.updateDoctor(id, dto);
    }

    @GetMapping
    public Collection<DoctorDto> search(
            // текст для поиска в поле name
            @RequestParam(required = false) String text,
            // список id пользователей
            @RequestParam(required = false) Set<Long> ids,
            @RequestParam(defaultValue = "0") @PositiveOrZero Integer from,
            @RequestParam(defaultValue = "10") @Positive Integer size) {
        log.info("Search doctors. Parameters: text {}, ids doctors {}, from {}, size {}", text,
                ids, from, size);
        return service.getAllDoctor(text, ids, from, size);
    }

    @DeleteMapping("/{doctorId}")
    public void deleteDoctorById(@PathVariable(value = "doctorId") Long id) {
        log.info("Delete doctor by id {}", id);
        service.deleteDoctor(id);
    }
}