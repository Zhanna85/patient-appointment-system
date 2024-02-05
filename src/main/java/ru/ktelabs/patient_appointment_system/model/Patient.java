package ru.ktelabs.patient_appointment_system.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import static ru.ktelabs.patient_appointment_system.util.Constants.PATTERN_CREATED_DATE;

@Entity
@Table(
        name = "patients",
        uniqueConstraints = {
                @UniqueConstraint(name = "patient_email_unique", columnNames = "email")
        }
)
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(
            name = "uuid",
            updatable = false
    )
    private UUID uuid;

    @Column(
            name = "name_patient",
            nullable = false
    )
    private String name;

    @Column(
            name = "date_of_birth",
            nullable = false
    )
    private LocalDate dateOfBirth; // дата рождения

    @Column(
            name = "phone_number",
            nullable = false
    )
    private String phoneNumber; // номер телефона

    @Column(
            name = "email",
            nullable = false
    )
    private String email; // адрес электронной почты (два пользователя не могут иметь одинаковый адрес электронной почты)

    @Column(
            name = "created_date",
            nullable = false,
            updatable = false
    )
    @DateTimeFormat(pattern = PATTERN_CREATED_DATE)
    private LocalDateTime created = LocalDateTime.now(); // дата создания

    public Long getId() {
        return id;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", uuid=" + uuid +
                ", name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", created=" + created +
                '}';
    }
}