package ru.ktelabs.patient_appointment_system.util;

public enum Messages {

    SAVE_MODEL("Saving {}"),
    DELETE_MODEL("Delete by id {}"),
    UPDATE_MODEL("Update {}"),
    GET_MODEL_BY_ID("Get by id {}"),
    GET_MODELS("Get models");

    private final String message;

    public String getMessage() {
        return message;
    }

    Messages(String message) {
        this.message = message;
    }
}