package ru.ktelabs.patient_appointment_system.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static ru.ktelabs.patient_appointment_system.util.Constants.*;

public class TimeSlotDto {

    private Long id; // id записи
    private Long doctorId;
    private Long patientId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = PATTERN_DATE)
    private LocalDate receptionDate; // время начала приёма
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = PATTERN_TIME)
    private LocalTime receptionStartTime; // время начала приёма
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = PATTERN_CREATED_DATE)
    private LocalDateTime createdDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = PATTERN_CREATED_DATE)
    private LocalDateTime lastUpdate;

    public TimeSlotDto(Long id, Long doctorId, Long patientId, LocalDate receptionDate, LocalTime receptionStartTime,
                       LocalDateTime createdDate, LocalDateTime lastUpdate) {
        this.id = id;
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.receptionDate = receptionDate;
        this.receptionStartTime = receptionStartTime;
        this.createdDate = createdDate;
        this.lastUpdate = lastUpdate;
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

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
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

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public LocalDate getReceptionDate() {
        return receptionDate;
    }

    public void setReceptionDate(LocalDate receptionDate) {
        this.receptionDate = receptionDate;
    }

    @Override
    public String toString() {
        return "TimeSlotDto{" +
                "id=" + id +
                ", doctorId=" + doctorId +
                ", patientId=" + patientId +
                ", receptionDate=" + receptionDate +
                ", receptionStartTime=" + receptionStartTime +
                ", createdDate=" + createdDate +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}