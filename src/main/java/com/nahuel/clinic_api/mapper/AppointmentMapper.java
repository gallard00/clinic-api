package com.nahuel.clinic_api.mapper;

import com.nahuel.clinic_api.dto.request.AppointmentRequestDto;
import com.nahuel.clinic_api.dto.response.AppointmentResponseDto;
import com.nahuel.clinic_api.entity.Appointment;
import com.nahuel.clinic_api.entity.AppointmentStatus;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class AppointmentMapper {

    public Appointment toEntity(AppointmentRequestDto request) {
        if (request == null) {return null;}

        return Appointment.builder()
                .name(request.getName())
                .date(LocalDate.parse(request.getDate()))
                .reason(request.getReason())
                .notes(request.getNotes())
                .appointmentStatus(request.getAppointmentStatus())
                .patient(request.getPatient())
                .practitioner(request.getPractitioner())
                .build();
    }

    public AppointmentResponseDto toResponse(Appointment appointment) {
        if (appointment == null) {return null;}

        AppointmentResponseDto response = new AppointmentResponseDto();
        response.setId(appointment.getId());
        response.setName(appointment.getName());
        response.setDate(appointment.getDate().toString());
        response.setReason(appointment.getReason());
        response.setNotes(appointment.getNotes());
        response.setAppointmentStatus(appointment.getAppointmentStatus());
        response.setPatient(appointment.getPatient());
        response.setPractitioner(appointment.getPractitioner());

        return response;
    }
}
