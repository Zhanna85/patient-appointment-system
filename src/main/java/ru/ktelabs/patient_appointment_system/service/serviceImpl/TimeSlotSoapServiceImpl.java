package ru.ktelabs.patient_appointment_system.service.serviceImpl;

import jakarta.jws.WebService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.ktelabs.patient_appointment_system.model.dto.TimeSlotDtoEnd;
import ru.ktelabs.patient_appointment_system.service.TimeSlotSoapService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@WebService(
        serviceName = "Schedules",
        portName = "SchedulesPort",
        targetNamespace = "http://service.ws.sample/",
        endpointInterface = "ru.ktelabs.patient_appointment_system.service.TimeSlotSoapService")
public class TimeSlotSoapServiceImpl implements TimeSlotSoapService {

    private final static Logger log = LoggerFactory.getLogger(TimeSlotSoapServiceImpl.class);
    private ScheduleService service;

    @Override
    public List<TimeSlotDtoEnd> createSchedules(LocalDate dateStart,
                                                LocalTime timeStart,
                                                Long duration,
                                                Integer count,
                                                Long idDoctor) {

        log.info("Create schedules web service");
        return null;
    }
}
