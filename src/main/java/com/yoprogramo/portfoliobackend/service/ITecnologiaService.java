package com.yoprogramo.portfoliobackend.service;

import java.util.List;

import com.yoprogramo.portfoliobackend.dto.TecnologiaDTO;
import com.yoprogramo.portfoliobackend.model.Tecnologia;

public interface ITecnologiaService {
    List<TecnologiaDTO> findAllTecnologias(Long personaId);
    TecnologiaDTO findTecnologiaById(Long id, Long personaId);
    TecnologiaDTO saveTecnologia(TecnologiaDTO tecnologiaDTO, Long personaId);
    TecnologiaDTO updateTecnologia(Long id, TecnologiaDTO tecnologiaDTO, Long personaId);
    void deleteTecnologia(Long id, Long personaId);
}
