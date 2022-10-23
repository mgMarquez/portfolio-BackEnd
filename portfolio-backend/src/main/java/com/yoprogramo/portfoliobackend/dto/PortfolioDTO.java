package com.yoprogramo.portfoliobackend.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class PortfolioDTO {
    private PersonaDTO persona;
    private List<EducacionDTO> educaciones;
    private List<ExperienciaDTO> experiencias;
    private List<ProyectoDTO> proyectos;
    private List<TecnologiaDTO> tecnologias;
}
