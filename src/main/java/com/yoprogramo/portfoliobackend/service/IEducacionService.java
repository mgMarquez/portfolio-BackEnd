package com.yoprogramo.portfoliobackend.service;

import com.yoprogramo.portfoliobackend.dto.EducacionDTO;

import java.util.List;

public interface IEducacionService {
    List<EducacionDTO> findAllEducacion(Long personaId);
    EducacionDTO findEducacionById(Long id, Long personaId);
    EducacionDTO saveEducacion(EducacionDTO educacionDTO, Long personaId);
    EducacionDTO updateEducacion(Long id, EducacionDTO educacionDTO, Long personaId);
    void deleteEducacion(Long id, Long personaId);
}
