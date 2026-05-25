package com.nahuel.clinic_api.dto.response;

import lombok.Data;

@Data
public class PractitionerResponseDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String Speciality;
    private String phone;
    private boolean active;
}
