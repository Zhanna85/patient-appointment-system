package ru.ktelabs.patient_appointment_system.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.UUID;

import static ru.ktelabs.patient_appointment_system.util.Constants.PATTERN_CREATED_DATE;

public class UserDto {

    protected Long id;
    protected UUID uuid;
    protected String name; // ФИО врача
    protected String phoneNumber; // номер телефона
    protected String email; // адрес электронной почты

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = PATTERN_CREATED_DATE)
    protected LocalDateTime created; // дата создания

    public UserDto() {
    }

    public UserDto(Long id, UUID uuid, String name, String phoneNumber, String email, LocalDateTime created) {
        this.id = id;
        this.uuid = uuid;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.created = created;
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

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }
}