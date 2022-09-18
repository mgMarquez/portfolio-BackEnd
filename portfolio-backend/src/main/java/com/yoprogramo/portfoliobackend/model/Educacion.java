package com.yoprogramo.portfoliobackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter @Setter
public class Educacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String escuela;
    private String descripcion;
    private String img;
    private String url;
    private LocalDate inicio;
    private LocalDate fin;
    @ManyToOne
    private Persona persona;
}
