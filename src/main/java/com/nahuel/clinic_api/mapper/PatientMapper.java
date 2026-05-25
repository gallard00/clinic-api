package com.nahuel.clinic_api.mapper;

import com.nahuel.clinic_api.dto.request.PatientRequestDto;
import com.nahuel.clinic_api.dto.response.PatientResponseDto;
import com.nahuel.clinic_api.entity.Patient;
import org.springframework.stereotype.Component;

@Component
public class PatientMapper {

    public Patient toEntity(PatientRequestDto request) {
        if (request == null) {return null;}
       return Patient.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .phone(request.getPhone())
                .birthdate(request.getBirthDay())
                .dni(request.getDni())
                .active(request.isActive())
                .appointments(request.getAppointments())
                .build();
    }

    public PatientResponseDto toResponse(Patient patient) {
        if (patient == null) {return null;}

        PatientResponseDto response = new PatientResponseDto();
        response.setFirstName(patient.getFirstName());
        response.setLastName(patient.getLastName());
        response.setPhone(patient.getPhone());
        response.setBirthDay(patient.getBirthdate());
        response.setDni(patient.getEmail());
        response.setActive(patient.isActive());
        response.setAppointments(patient.getAppointments());

        return response;
    }
}
