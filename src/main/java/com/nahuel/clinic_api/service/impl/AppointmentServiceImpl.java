package com.nahuel.clinic_api.service.impl;

import com.nahuel.clinic_api.dto.request.AppointmentRequestDto;
import com.nahuel.clinic_api.dto.response.AppointmentResponseDto;
import com.nahuel.clinic_api.entity.Appointment;
import com.nahuel.clinic_api.mapper.AppointmentMapper;
import com.nahuel.clinic_api.repository.AppointmentRepository;
import com.nahuel.clinic_api.service.AppointmentService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final AppointmentMapper mapper;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository, AppointmentMapper mapper) {
        this.appointmentRepository = appointmentRepository;
        this.mapper = mapper;
    }

    @Override
    public AppointmentResponseDto create(AppointmentRequestDto appointmentRequestDto) {
        Appointment appointment = mapper.toEntity(appointmentRequestDto);
        Appointment saved = appointmentRepository.save(appointment);
        return mapper.toResponse(saved);
    }

    @Override
    public AppointmentResponseDto update(Long id, AppointmentRequestDto appointmentUpdateRequestDto) {
        Appointment existing = appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found with id" + id));

        existing.setName(appointmentUpdateRequestDto.getName());
        existing.setDate(LocalDate.parse(appointmentUpdateRequestDto.getDate()));
        existing.setNotes(appointmentUpdateRequestDto.getNotes());
        existing.setAppointmentStatus(appointmentUpdateRequestDto.getAppointmentStatus());
        existing.setReason(appointmentUpdateRequestDto.getReason());
        existing.setPatient(appointmentUpdateRequestDto.getPatient());

        Appointment appointmentUpdate = appointmentRepository.save(existing);
        return mapper.toResponse(appointmentUpdate);
    }

    @Override
    public List<AppointmentResponseDto> findAll() {
        return appointmentRepository.findAll().stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<AppointmentResponseDto> findById(Long id) {
        return appointmentRepository.findById(id)
                .map(mapper::toResponse);
    }

    @Override
    public void delete(Long id) {
        appointmentRepository.deleteById(id);
    }

}
