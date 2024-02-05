package ru.ktelabs.patient_appointment_system.service.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ktelabs.patient_appointment_system.exception.NotFoundException;
import ru.ktelabs.patient_appointment_system.model.Doctor;
import ru.ktelabs.patient_appointment_system.model.dto.DoctorDto;
import ru.ktelabs.patient_appointment_system.model.dto.NewDoctorDto;
import ru.ktelabs.patient_appointment_system.model.mapper.DoctorMapper;
import ru.ktelabs.patient_appointment_system.service.DoctorService;
import ru.ktelabs.patient_appointment_system.storage.DoctorRepository;
import ru.ktelabs.patient_appointment_system.storage.SpecializationRepository;
import ru.ktelabs.patient_appointment_system.util.PaginationSetup;

import java.util.*;
import java.util.stream.Collectors;

import static ru.ktelabs.patient_appointment_system.util.Messages.*;

@Service
@Transactional(readOnly = true)
public class DoctorServiceImpl implements DoctorService {

    private final static Logger log = LoggerFactory.getLogger(DoctorServiceImpl.class);
    private final DoctorRepository repository;
    private final SpecializationRepository specializationRepository;

    public DoctorServiceImpl(DoctorRepository repository, SpecializationRepository specializationRepository) {
        this.repository = repository;
        this.specializationRepository = specializationRepository;
    }

    private Doctor findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("User with id = " + id
                + " was not found"));
    }

    @Transactional
    @Override
    public DoctorDto creatDoctor(NewDoctorDto dto) {
        Doctor doctor = DoctorMapper.toDoctor(dto);

        if (dto.getSpecialties() != null) {
            doctor.setSpecialties(specializationRepository.findAllById(dto.getSpecialties()));
        }
        log.info(SAVE_MODEL.getMessage(), doctor);
        return DoctorMapper.toDoctorDto(repository.save(doctor));
    }

    @Transactional
    @Override
    public DoctorDto updateDoctor(Long id, NewDoctorDto dto) {
        Doctor doctor = findById(id);
        String name = dto.getName();
        String phoneNumber = dto.getPhoneNumber();
        String email = dto.getEmail();

        if (name != null) {
            doctor.setName(name);
        }
        if (phoneNumber != null) {
            doctor.setPhoneNumber(phoneNumber);
        }
        if (email != null) {
            doctor.setEmail(email);
        }
        if (dto.getSpecialties() != null) {
            doctor.setSpecialties(specializationRepository.findAllById(dto.getSpecialties()));
        }
        log.info(UPDATE_MODEL.getMessage(), doctor);

        return DoctorMapper.toDoctorDto(repository.save(doctor));
    }

    @Override
    public void deleteDoctor(Long id) {
        log.info(DELETE_MODEL.getMessage(), id);
        findById(id);
        repository.deleteById(id);
    }

    @Override
    public Collection<DoctorDto> getAllDoctor(String text,
                                              Set<Long> ids,
                                              Integer from,
                                              Integer size) {
        log.info(GET_MODELS.getMessage());
        PageRequest pageable = new PaginationSetup(from, size, Sort.unsorted());
        List<Doctor> doctors = repository.search(text, ids, pageable);
        return doctors.stream()
                .map(DoctorMapper::toDoctorDto)
                .collect(Collectors.toList());
    }
}