package com.yoprogramo.portfoliobackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@Table(name = "educaciones")
public class Educacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String titulo;
    @Column(nullable = false)
    private String escuela;
    @Column(nullable = false)
    private String descripcion;
    private String imgUrl;
    private String webUrl;
    @Column(nullable = false)
    private String inicio;
    @Column(nullable = false)
    private String fin;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "persona_id", nullable = false)
    private Persona persona;
}
