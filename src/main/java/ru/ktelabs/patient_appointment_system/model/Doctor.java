package ru.ktelabs.patient_appointment_system.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static ru.ktelabs.patient_appointment_system.util.Constants.PATTERN_CREATED_DATE;

@Entity
@Table(
        name = "doctors",
        uniqueConstraints = {
                @UniqueConstraint(name = "doctor_email_unique", columnNames = "email")
        }
)
public class Doctor {

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
            name = "name_doctor",
            nullable = false
    )
    private String name; // ФИО врача

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

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name = "doctor_specialization",
            joinColumns = @JoinColumn(name = "id_doctor"),
            inverseJoinColumns = @JoinColumn(name = "id_specialization")
    )
    private List<Specialization> specialties; // специальности

    public void setId(Long id) {
        this.id = id;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
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

    public List<Specialization> getSpecialties() {
        return specialties;
    }

    public void setSpecialties(List<Specialization> specialties) {
        this.specialties = specialties;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", uuid=" + uuid +
                ", name='" + name + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                ", created=" + created +
                ", specialties=" + specialties +
                '}';
    }
}