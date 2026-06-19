package com.nahuel.clinic_api.controller;

import com.nahuel.clinic_api.dto.response.AppointmentResponseDto;
import com.nahuel.clinic_api.mapper.AppointmentMapper;
import com.nahuel.clinic_api.service.AppointmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/appointment")
public class AppointmentController {

    private final AppointmentService appointmentService;
    private final AppointmentMapper appointmentMapper;

    public AppointmentController(AppointmentService appointmentService, AppointmentMapper appointmentMapper) {
        this.appointmentService = appointmentService;
        this.appointmentMapper = appointmentMapper;
    }

    @GetMapping
    public List<AppointmentResponseDto> getAll() {
        return appointmentService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppointmentResponseDto> getById(@PathVariable Long id) {
        return appointmentService.findById()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
