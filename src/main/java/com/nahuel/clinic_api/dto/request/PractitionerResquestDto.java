package com.nahuel.clinic_api.dto.request;

import lombok.Data;

@Data
public class PractitionerResquestDto {

    private String firstName;
    private String lastName;
    private String email;
    private String Speciality;
    private String phone;
    private boolean active;
}
