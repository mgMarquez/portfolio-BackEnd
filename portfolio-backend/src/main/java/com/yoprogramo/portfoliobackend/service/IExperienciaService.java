package com.yoprogramo.portfoliobackend.service;

import java.util.List;

import com.yoprogramo.portfoliobackend.dto.ExperienciaDTO;

public interface IExperienciaService {
    List<ExperienciaDTO> findAllExperiencias(Long personaId);
    ExperienciaDTO findExperienciaById(Long id);
    ExperienciaDTO saveExperiencia(ExperienciaDTO experienciaDTO, Long personaId);
    ExperienciaDTO updateExperiencia(Long id, ExperienciaDTO experienciaDTO, Long personaId);
    void deleteExperiencia(Long id, Long personaId);
}
