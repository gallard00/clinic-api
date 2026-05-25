package com.nahuel.clinic_api.service;

import com.nahuel.clinic_api.dto.request.PatientRequestDto;
import com.nahuel.clinic_api.dto.response.PatientResponseDto;

import java.util.List;
import java.util.Optional;

public interface PatientService {
    PatientResponseDto create(PatientRequestDto patientRequestDto);
    PatientResponseDto update(Long id, PatientRequestDto patientUpdateRequestDto);
    Optional<PatientResponseDto> findById(Long id);
    List<PatientResponseDto> findAll();
    void delete(Long id);
}
