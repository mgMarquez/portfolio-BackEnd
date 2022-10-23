package com.yoprogramo.portfoliobackend.service;

import com.yoprogramo.portfoliobackend.dto.ProyectoDTO;

import java.util.List;

public interface IProyectoService {
    List<ProyectoDTO> findAllProyectos(Long personaId);
    ProyectoDTO findProyectoById(Long id, Long personaId);
    ProyectoDTO saveProyecto(ProyectoDTO proyectoDTO, Long personaId);
    ProyectoDTO updateProyecto(Long id, ProyectoDTO proyectoDTO, Long personaId);
    void deleteProyecto(Long id, Long personaId);
}
