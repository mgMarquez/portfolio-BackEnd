package com.yoprogramo.portfoliobackend.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Getter @Setter
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private LocalDate fechaNac;
    private String profesion;
    private String nacionalidad;
    private String ubicacion;
    private String acercaDe;
    private String email;
    private String foto;
    private String banner;

}
