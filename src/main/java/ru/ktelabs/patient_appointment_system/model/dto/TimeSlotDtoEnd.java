package ru.ktelabs.patient_appointment_system.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static ru.ktelabs.patient_appointment_system.util.Constants.*;

public class TimeSlotDtoEnd {

    private Long id; // id записи
    private Long doctorId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = PATTERN_DATE)
    private LocalDate receptionDate; // дата начала приёма
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = PATTERN_TIME)
    private LocalTime receptionStartTime; // время начала приёма
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = PATTERN_CREATED_DATE)
    private LocalDateTime createdDate;

    public TimeSlotDtoEnd() {
    }

    public TimeSlotDtoEnd(Long id, Long doctorId, LocalDate receptionDate, LocalTime receptionStartTime,
                          LocalDateTime createdDate) {
        this.id = id;
        this.doctorId = doctorId;
        this.receptionDate = receptionDate;
        this.receptionStartTime = receptionStartTime;
        this.createdDate = createdDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public LocalTime getReceptionStartTime() {
        return receptionStartTime;
    }

    public void setReceptionStartTime(LocalTime receptionStartTime) {
        this.receptionStartTime = receptionStartTime;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDate getReceptionDate() {
        return receptionDate;
    }

    public void setReceptionDate(LocalDate receptionDate) {
        this.receptionDate = receptionDate;
    }

    @Override
    public String toString() {
        return "TimeSlotDtoEnd{" +
                "id=" + id +
                ", doctorId=" + doctorId +
                ", receptionDate=" + receptionDate +
                ", receptionStartTime=" + receptionStartTime +
                ", createdDate=" + createdDate +
                '}';
    }
}