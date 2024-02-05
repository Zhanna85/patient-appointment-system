package ru.ktelabs.patient_appointment_system.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class NewUserDto {

    @NotBlank
    @Size(min = 5, max = 255)
    protected String name; // ФИО врача

    @NotBlank
    @Size(min = 11)
    protected String phoneNumber; // номер телефона

    @NotBlank
    @Email
    @Size(min = 6, max = 255)
    protected String email; // адрес электронной почты (два пользователя не могут иметь одинаковый адрес электронной почты)

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "NewUserDto{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}