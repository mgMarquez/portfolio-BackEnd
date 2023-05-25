package com.yoprogramo.portfoliobackend.model;

import com.yoprogramo.portfoliobackend.security.entity.Rol;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String nombre;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String contrasenia;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)//, optional = false)
    private Persona persona;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_rol",
                joinColumns = @JoinColumn(name = "usuario_id"),
                inverseJoinColumns = @JoinColumn(name = "rol_id"))
    @Enumerated(EnumType.STRING)
    private Set<Rol> roles = new HashSet<>();
}
