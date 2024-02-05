package ru.ktelabs.patient_appointment_system.service.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ktelabs.patient_appointment_system.exception.NotFoundException;
import ru.ktelabs.patient_appointment_system.model.Specialization;
import ru.ktelabs.patient_appointment_system.model.dto.SpecializationDto;
import ru.ktelabs.patient_appointment_system.model.mapper.SpecializationMapper;
import ru.ktelabs.patient_appointment_system.service.SpecializationService;
import ru.ktelabs.patient_appointment_system.storage.SpecializationRepository;
import ru.ktelabs.patient_appointment_system.util.PaginationSetup;

import java.util.Collection;
import java.util.stream.Collectors;

import static ru.ktelabs.patient_appointment_system.util.Messages.*;

@Service
@Transactional(readOnly = true)
public class SpecializationServiceImpl implements SpecializationService {

    private final static Logger log = LoggerFactory.getLogger(SpecializationServiceImpl.class);
    private final SpecializationRepository repository;

    private Specialization findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("User with id = " + id + " was not found"));
    }

    public SpecializationServiceImpl(SpecializationRepository repository) {
        this.repository = repository;
    }

    @Transactional
    @Override
    public SpecializationDto creatSpecialization(SpecializationDto dto) {
        Specialization specialization = repository.save(SpecializationMapper.toSpecialization(dto));
        log.info(SAVE_MODEL.getMessage(), specialization);
        return SpecializationMapper.toSpecializationDto(specialization);
    }

    @Transactional
    @Override
    public SpecializationDto updateSpecialization(Long id, SpecializationDto dto) {
        Specialization specialization = findById(id);
        specialization.setName(dto.getName());
        specialization = repository.save(specialization);
        log.info(UPDATE_MODEL.getMessage(), specialization);
        return SpecializationMapper.toSpecializationDto(specialization);
    }

    @Transactional
    @Override
    public void deleteSpecialization(Long id) {
        log.info(DELETE_MODEL.getMessage(), id);
        findById(id);
        repository.deleteById(id);
    }

    @Override
    public Collection<SpecializationDto> getAllSpecialization(Integer from, Integer size) {
        log.info(GET_MODELS.getMessage());
        PageRequest pageable = new PaginationSetup(from, size, Sort.unsorted());
        return repository.findAll(pageable).stream()
                .map(SpecializationMapper::toSpecializationDto)
                .collect(Collectors.toList());
    }
}