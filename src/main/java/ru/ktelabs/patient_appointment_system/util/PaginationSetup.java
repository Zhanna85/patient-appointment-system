package ru.ktelabs.patient_appointment_system.util;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

public class PaginationSetup extends PageRequest {
    public PaginationSetup(int pageNumber, int pageSize, Sort sort) {
        super(pageNumber / pageSize, pageSize, sort);
    }
}