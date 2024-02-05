DROP TABLE IF EXISTS time_slot, doctor_specialization, patients, doctors, specialties CASCADE;

CREATE TABLE IF NOT EXISTS specialties
(
    id                  BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL PRIMARY KEY,
    name_specialization varchar(255)                            NOT NULL UNIQUE,
    created_date        TIMESTAMP WITHOUT TIME ZONE             NOT NULL
);

CREATE TABLE IF NOT EXISTS doctors
(
    id           BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL PRIMARY KEY,
    uuid         uuid NOT NULL UNIQUE,
    name_doctor  varchar(255)                            NOT NULL,
    phone_number varchar                                 NOT NULL,
    email        varchar(255)                            NOT NULL UNIQUE,
    created_date TIMESTAMP WITHOUT TIME ZONE             NOT NULL
);

CREATE TABLE IF NOT EXISTS doctor_specialization
(
    id_doctor         bigint REFERENCES doctors (id) ON DELETE CASCADE     NOT NULL,
    id_specialization bigint REFERENCES specialties (id) ON DELETE CASCADE NOT NULL,
    PRIMARY KEY (id_doctor, id_specialization)
);

CREATE TABLE IF NOT EXISTS patients
(
    id            BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL PRIMARY KEY,
    uuid          uuid NOT NULL UNIQUE,
    name_patient  varchar(255)                            NOT NULL,
    date_of_birth DATE                                    NOT NULL,
    phone_number  varchar                                 NOT NULL,
    email         varchar(255)                            NOT NULL UNIQUE,
    created_date  TIMESTAMP WITHOUT TIME ZONE             NOT NULL
);

CREATE TABLE IF NOT EXISTS time_slot
(
    id                   BIGINT GENERATED BY DEFAULT AS IDENTITY          NOT NULL PRIMARY KEY,
    doctor_id            bigint REFERENCES doctors (id) ON DELETE CASCADE NOT NULL,
    patient_id           bigint REFERENCES patients (id) ON DELETE CASCADE,
    reception_date       DATE                                             NOT NULL,
    reception_start_time TIME WITHOUT TIME ZONE                           NOT NULL,
    created_date         TIMESTAMP WITHOUT TIME ZONE                      NOT NULL,
    last_update          TIMESTAMP WITHOUT TIME ZONE
);