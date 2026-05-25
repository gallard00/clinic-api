package com.nahuel.clinic_api.service.impl;

import com.nahuel.clinic_api.dto.request.PatientRequestDto;
import com.nahuel.clinic_api.dto.response.PatientResponseDto;
import com.nahuel.clinic_api.entity.Patient;
import com.nahuel.clinic_api.mapper.PatientMapper;
import com.nahuel.clinic_api.repository.PatientRepository;
import com.nahuel.clinic_api.service.PatientService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class PatientServiceImpl implements PatientService {

    private final PatientRepository repository;
    private final PatientMapper mapper;

    public PatientServiceImpl(PatientMapper mapper, PatientRepository repository) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public PatientResponseDto create(PatientRequestDto patientRequestDto) {
        Patient patient = mapper.toEntity(patientRequestDto);
        Patient saved = repository.save(patient);
        return mapper.toResponse(saved);
    }

    @Override
    public PatientResponseDto update(Long id, PatientRequestDto patientUpdateRequestDto) {
        Patient existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not gfound by id" + id));

        existing.setFirstName(patientUpdateRequestDto.getFirstName());
        existing.setLastName(patientUpdateRequestDto.getLastName());
        existing.setPhone(patientUpdateRequestDto.getPhone());
        existing.setBirthdate(patientUpdateRequestDto.getBirthDay());
        existing.setDni(patientUpdateRequestDto.getDni());
        existing.setActive(patientUpdateRequestDto.isActive());
        existing.setEmail(patientUpdateRequestDto.getEmail());
        existing.setAppointments(patientUpdateRequestDto.getAppointments());

        Patient update = repository.save(existing);
        return mapper.toResponse(update);
    }

    @Override
    public List<PatientResponseDto> findAll(){
        return repository.findAll().stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<PatientResponseDto> findById(Long id) {
        return repository.findById(id)
                .map(mapper::toResponse);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
