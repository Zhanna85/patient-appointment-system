package ru.ktelabs.patient_appointment_system.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "specialties")
public class Specialization {

    @Id
    private Long id;

    @Column(
            name = "name_specialization",
            nullable = false
    )
    private String name; // специальность

    @Column(
            name = "created_date",
            nullable = false,
            updatable = false
    )
    private LocalDateTime createdDate = LocalDateTime.now();

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setName(String specialization) {
        this.name = specialization;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    @Override
    public String toString() {
        return "Specialization{" +
                "id=" + id +
                ", specialization='" + name + '\'' +
                ", createdDate=" + createdDate +
                '}';
    }
}