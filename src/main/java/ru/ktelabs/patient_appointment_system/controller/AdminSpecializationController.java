package ru.ktelabs.patient_appointment_system.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.ktelabs.patient_appointment_system.model.dto.SpecializationDto;
import ru.ktelabs.patient_appointment_system.service.SpecializationService;

import java.util.Collection;

@RestController
@RequestMapping("/admin/specialties")
@Validated
public class AdminSpecializationController {

    private final static Logger log = LoggerFactory.getLogger(AdminSpecializationController.class);
    private final SpecializationService service;

    public AdminSpecializationController(SpecializationService service) {
        this.service = service;
    }

    @PostMapping
    public SpecializationDto saveSpecialization(@Valid @RequestBody SpecializationDto dto) {
        log.info("Creating {}", dto);
        return service.creatSpecialization(dto);
    }

    @PatchMapping("/{specializationId}")
    public SpecializationDto updateSpecialization(@PathVariable(value = "specializationId") Long specializationId,
                                                  @Valid @RequestBody SpecializationDto dto) {
        log.info("Updating {} by id {}", dto, specializationId);
        return service.updateSpecialization(specializationId, dto);
    }

    @GetMapping
    public Collection<SpecializationDto> getAllSpecialties(@RequestParam(defaultValue = "0") @PositiveOrZero Integer from,
                                                           @RequestParam(defaultValue = "10") @Positive Integer size) {
        log.info("Get all specialties. Parameters: from {}, size {}", from, size);
        return service.getAllSpecialization(from, size);
    }

    @DeleteMapping("/{specializationId}")
    public void deleteSpecialization(@PathVariable(value = "specializationId") Long specializationId) {
        log.info("Delete specialization by id {}", specializationId);
        service.deleteSpecialization(specializationId);
    }
}