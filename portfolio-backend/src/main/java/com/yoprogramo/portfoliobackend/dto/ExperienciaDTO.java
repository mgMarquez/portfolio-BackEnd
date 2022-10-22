package com.yoprogramo.portfoliobackend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ExperienciaDTO {
    private Long id;
    private String posicion;
    private String compania;
    private String descripcion;
    private String imgUrl;
    private String webUrl;
    private String inicio;
    private String Fin;
}
