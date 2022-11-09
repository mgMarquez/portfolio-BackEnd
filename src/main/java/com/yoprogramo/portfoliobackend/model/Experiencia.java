package com.yoprogramo.portfoliobackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@Table(name = "experiencias")
public class Experiencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String posicion;
    @Column(nullable = false)
    private String compania;
    @Column(nullable = false)
    private String descripcion;
    private String imgUrl;
    private String webUrl;
    @Column(nullable = false)
    private String inicio;
    @Column(nullable = false)
    private String Fin;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "persona_id", nullable = false)
    private Persona persona;
}
