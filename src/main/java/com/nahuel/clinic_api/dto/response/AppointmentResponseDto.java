package com.nahuel.clinic_api.dto.response;

import com.nahuel.clinic_api.entity.AppointmentStatus;
import com.nahuel.clinic_api.entity.Patient;
import com.nahuel.clinic_api.entity.Practitioner;
import lombok.Data;

@Data
public class AppointmentResponseDto {

    private Long id;
    private String name;
    private String date;
    private String reason;
    private String notes;
    private AppointmentStatus appointmentStatus;
    private Patient patient;
    private Practitioner practitioner;
}
