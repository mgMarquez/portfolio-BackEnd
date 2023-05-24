package com.yoprogramo.portfoliobackend.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
public class PersonaDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private LocalDate fechaNac;
    private String profesion;
    private String nacionalidad;
    private String ubicacion;
    private String acercaDe;
    private String email;
    private String telefono;
    private String fotoUrl;
    private String bannerUrl;
}
