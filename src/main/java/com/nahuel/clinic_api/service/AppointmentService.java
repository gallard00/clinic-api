package com.nahuel.clinic_api.service;

import com.nahuel.clinic_api.dto.request.AppointmentRequestDto;
import com.nahuel.clinic_api.dto.response.AppointmentResponseDto;
import com.nahuel.clinic_api.entity.Appointment;

import java.util.List;
import java.util.Optional;

public interface AppointmentService {
    AppointmentResponseDto create(AppointmentRequestDto appointmentRequestDto);
    AppointmentResponseDto update(Long id, AppointmentRequestDto appointmentUpdateRequestDto);
    Optional<AppointmentResponseDto> findById(Long id);
    List<AppointmentResponseDto> findAll();
    void delete(Long id);
}
