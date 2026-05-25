package com.nahuel.clinic_api.dto.response;

import com.nahuel.clinic_api.entity.Appointment;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class PatientResponseDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String phone;
    private LocalDate birthDay;
    private String dni;
    private boolean active;
    private String email;
    private List<Appointment> appointments;
}
