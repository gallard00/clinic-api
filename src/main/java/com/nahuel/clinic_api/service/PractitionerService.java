package com.nahuel.clinic_api.service;

import com.nahuel.clinic_api.dto.request.PractitionerResquestDto;
import com.nahuel.clinic_api.dto.response.PractitionerResponseDto;

import java.util.List;
import java.util.Optional;

public interface PractitionerService {

    PractitionerResponseDto create(PractitionerResquestDto practitionerResquestDto);
    PractitionerResponseDto update(Long id, PractitionerResquestDto practitionerUpdateRequestDto);
    Optional<PractitionerResponseDto> findById(Long id);
    List<PractitionerResponseDto> findAll();
    void delete(Long id);
}
