package ru.ktelabs.patient_appointment_system.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static ru.ktelabs.patient_appointment_system.util.Constants.*;

@Entity
@Table(name = "time_slot")
public class TimeSlot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @Column(
            name = "reception_date"
    )
    @DateTimeFormat(pattern = PATTERN_DATE)
    private LocalDate receptionDate; // дата приема

    @Column(
            name = "reception_start_time",
            nullable = false
    )
    @DateTimeFormat(pattern = PATTERN_TIME)
    private LocalTime receptionStartTime; // время начала приёма

    @Column(
            name = "created_date"
    )
    @DateTimeFormat(pattern = PATTERN_CREATED_DATE)
    private LocalDateTime createdDate = LocalDateTime.now();

    @Column(
            name = "last_update"
    )
    @DateTimeFormat(pattern = PATTERN_CREATED_DATE)
    private LocalDateTime lastUpdate;

    public TimeSlot() {
    }

    public TimeSlot(Doctor doctor, LocalDate receptionDate, LocalTime receptionStartTime) {
        this.doctor = doctor;
        this.receptionDate = receptionDate;
        this.receptionStartTime = receptionStartTime;
    }

    public Long getId() {
        return id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDoctor(Doctor doctorId) {
        this.doctor = doctorId;
    }

    public void setPatient(Patient patientId) {
        this.patient = patientId;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public LocalTime getReceptionStartTime() {
        return receptionStartTime;
    }

    public void setReceptionStartTime(LocalTime receptionStartTime) {
        this.receptionStartTime = receptionStartTime;
    }

    public LocalDate getReceptionDate() {
        return receptionDate;
    }

    public void setReceptionDate(LocalDate receptionDate) {
        this.receptionDate = receptionDate;
    }

    @Override
    public String toString() {
        return "TimeSlot{" +
                "id=" + id +
                ", doctor=" + doctor +
                ", patient=" + patient +
                ", receptionDate=" + receptionDate +
                ", receptionStartTime=" + receptionStartTime +
                ", createdDate=" + createdDate +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}