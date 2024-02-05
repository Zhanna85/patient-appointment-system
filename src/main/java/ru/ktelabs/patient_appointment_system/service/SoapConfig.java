package ru.ktelabs.patient_appointment_system.service;

import jakarta.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.ktelabs.patient_appointment_system.service.serviceImpl.TimeSlotSoapServiceImpl;

@Configuration
public class SoapConfig {

    @Autowired
    private Bus bus;

    @Bean
    public Endpoint schedulesEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, new TimeSlotSoapServiceImpl());
        endpoint.publish("/ServiceSchedule");

        return endpoint;
    }
}