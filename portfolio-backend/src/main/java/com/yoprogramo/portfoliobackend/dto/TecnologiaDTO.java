package com.yoprogramo.portfoliobackend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class TecnologiaDTO {
    private Long id;
    private String nombre;
    private String descripcion;
    private String imgUrl;
    private int progreso;
}
