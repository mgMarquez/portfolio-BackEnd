package com.yoprogramo.portfoliobackend.dto;

import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class EducacionDTO {
    private Long id;
    private String titulo;
    private String escuela;
    private String descripcion;
    private String imgUrl;
    private String webUrl;
    private String inicio;
    private String fin;
}
