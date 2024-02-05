package ru.ktelabs.patient_appointment_system.service;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.xml.ws.RequestWrapper;
import jakarta.xml.ws.ResponseWrapper;
import org.springframework.validation.annotation.Validated;
import ru.ktelabs.patient_appointment_system.model.dto.TimeSlotDtoEnd;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@WebService(targetNamespace = "http://service.ws.sample/", name = "TimeSlotSoapService")
@Validated
public interface TimeSlotSoapService {

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(
            localName = "createScheduleRequest",
            targetNamespace = "http://service.ws.sample/",
            className = "sample.ws.service.RequestCreateSchedule")
    @WebMethod(action = "urn:CreateSchedule")
    @ResponseWrapper(
            localName = "createScheduleResponse",
            targetNamespace = "http://service.ws.sample/",
            className = "sample.ws.service.CreateScheduleResponse")
    List<TimeSlotDtoEnd> createSchedules(@WebParam(name = "dateStart", targetNamespace = "") @FutureOrPresent LocalDate dateStart,
                                         @WebParam(name = "timeStart", targetNamespace = "") @FutureOrPresent LocalTime timeStart,
                                         @WebParam(name = "duration", targetNamespace = "") @Positive Long duration,
                                         @WebParam(name = "count", targetNamespace = "") @Positive Integer count,
                                         @WebParam(name = "idDoctor", targetNamespace = "") @Positive Long idDoctor);
}