package com.yoprogramo.portfoliobackend.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter @Setter
public class PersonaDto implements Serializable {
    private String nombre;
    private String apellido;
    private LocalDate fechaNac;
    private String profesion;
    private String nacionalidad;
    private String ubicacion;
    private String acercaDe;
    private String email;
    private String telefono;
    private String foto;
    private String banner;
    private Long usuario_id;
}
