package com.yoprogramo.portfoliobackend.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter @Setter
public class UsuarioDTO {
    private Long id;
    private String nombre;
    private String email;
    private String contrasenia;
    private Set<String> roles = new HashSet<>();
}
