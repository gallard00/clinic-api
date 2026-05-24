package com.nahuel.clinic_api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity //referenciando que es una entidad
@Data // para los getters y setters
@NoArgsConstructor // genera un constructor de la clase vacio ej: Patient()
@AllArgsConstructor // genera un constructor de la clase con sus argumentos ej: Patient(Patient patient)
@Builder // para poder usar build en el objeto patient ej: patient.builder.atributos.build
@Table(name = "patient") // referencia de la clase en la db
public class Patient {

    @Id //referencia que el atributo id es la clave primaria en la db
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "phone")
    private String phone;

    @Column(name = "birthDate")
    private LocalDate birthdate;

    @Column(name = "dni")
    private String dni;

    @Column(name = "active")
    private boolean active;

    @Column(name = "email", nullable = false)
    private String email;

}
