package com.nahuel.clinic_api.mapper;

import com.nahuel.clinic_api.dto.request.PractitionerResquestDto;
import com.nahuel.clinic_api.dto.response.PractitionerResponseDto;
import com.nahuel.clinic_api.entity.Practitioner;
import org.springframework.stereotype.Component;

@Component
public class PractitionerMapper {

    public Practitioner toEntity(PractitionerResquestDto request) {
        if (request == null) {return null;}

       return Practitioner.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .specialty(request.getSpeciality())
                .phone(request.getPhone())
                .active(request.isActive())
                .build();
    }

    public PractitionerResponseDto toResponse(Practitioner practitioner) {
        if (practitioner == null) {
            return null;
        }

        PractitionerResponseDto response = new PractitionerResponseDto();
        response.setFirstName(practitioner.getFirstName());
        response.setLastName(practitioner.getLastName());
        response.setEmail(practitioner.getEmail());
        response.setSpeciality(practitioner.getSpecialty());
        response.setPhone(practitioner.getPhone());
        response.setActive(practitioner.isActive());

        return response;
    }
}
