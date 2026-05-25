package com.nahuel.clinic_api.service.impl;

import com.nahuel.clinic_api.dto.request.PractitionerResquestDto;
import com.nahuel.clinic_api.dto.response.PractitionerResponseDto;
import com.nahuel.clinic_api.entity.Practitioner;
import com.nahuel.clinic_api.mapper.PractitionerMapper;
import com.nahuel.clinic_api.repository.PractitionerRepository;
import com.nahuel.clinic_api.service.PractitionerService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class PractitionerServiceImpl implements PractitionerService {

    private final PractitionerRepository repository;
    private final PractitionerMapper mapper;

    public PractitionerServiceImpl(PractitionerMapper mapper, PractitionerRepository repository) {
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public PractitionerResponseDto create(PractitionerResquestDto practitionerResquestDto) {
        Practitioner practitioner = mapper.toEntity(practitionerResquestDto);
        Practitioner saved = repository.save(practitioner);
        return mapper.toResponse(saved);
    }

    @Override
    public PractitionerResponseDto update(Long id, PractitionerResquestDto practitionerUpdateRequestDto) {
        Practitioner existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Practitioner noy found by id:" + id));

        existing.setFirstName(practitionerUpdateRequestDto.getFirstName());
        existing.setLastName(practitionerUpdateRequestDto.getLastName());
        existing.setEmail(practitionerUpdateRequestDto.getEmail());
        existing.setSpecialty(practitionerUpdateRequestDto.getSpeciality());
        existing.setPhone(practitionerUpdateRequestDto.getPhone());
        existing.setActive(practitionerUpdateRequestDto.isActive());

        Practitioner practitionerUpdate = repository.save(existing);
        return mapper.toResponse(practitionerUpdate);
    }

    @Override
    public Optional<PractitionerResponseDto> findById(Long id) {
       return repository.findById(id)
               .map(mapper::toResponse);
    }

    @Override
    public List<PractitionerResponseDto> findAll() {
        return repository.findAll().stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
