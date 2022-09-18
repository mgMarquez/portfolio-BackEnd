package com.yoprogramo.portfoliobackend.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

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
    private String telefono;
    private String foto;
    private String banner;
    
    @OneToOne    
    private Usuario usuario;
    // @OneToMany(mappedBy = "persona")
    // private List<Educacion> educaciones;
    // @OneToMany(mappedBy = "persona")
    // private List<Experiencia> experiencias;
    // @OneToMany(mappedBy = "persona")
    // private List<Proyecto> proyectos;
    // @OneToMany(mappedBy = "persona")
    // private List<Tecnologia> tecnologias;
}
