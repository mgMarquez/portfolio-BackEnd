package com.yoprogramo.portfoliobackend.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter @Setter
public class ProyectoDTO {
    private Long id;
    private String titulo;
    private String descripcion;
    private String imgUrl;
    private String webUrl;
}
