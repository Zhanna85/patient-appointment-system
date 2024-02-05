package ru.ktelabs.patient_appointment_system.controller;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.ktelabs.patient_appointment_system.model.dto.NewPatientDto;
import ru.ktelabs.patient_appointment_system.model.dto.PatientDto;
import ru.ktelabs.patient_appointment_system.service.PatientService;

@RestController
@RequestMapping("/patients")
@Validated
public class PublicPatientController {

    private final static Logger log = LoggerFactory.getLogger(PublicPatientController.class);
    private final PatientService service;

    public PublicPatientController(PatientService service) {
        this.service = service;
    }

    @PostMapping
    public PatientDto savePatient(@Valid @RequestBody NewPatientDto dto) {
        log.info("Creating {}", dto);
        return service.creatPatient(dto);
    }

    @PatchMapping("/{patientId}")
    public PatientDto updatePatient(@PathVariable(value = "patientId") Long id,
                                  @Valid @RequestBody NewPatientDto dto) {
        log.info("Updating {} by id {}", dto, id);
        return service.updatePatient(id, dto);
    }

    @GetMapping("/{patientId}")
    public PatientDto getPatientById(@PathVariable(value = "patientId") Long id) {
        log.info("Get patient by id {}", id);
        return service.getPatient(id);
    }
}