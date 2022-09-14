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
public class Experiencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String posicion;
    private String compania;
    private String descripcion;
    private String img;
    private String url;
    private LocalDate inicio;
    private LocalDate Fin;
}
