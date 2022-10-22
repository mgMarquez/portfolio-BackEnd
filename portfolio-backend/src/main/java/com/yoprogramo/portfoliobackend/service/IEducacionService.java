package com.yoprogramo.portfoliobackend.service;

import com.yoprogramo.portfoliobackend.dto.EducacionDTO;

import java.util.List;

public interface IEducacionService {
    List<EducacionDTO> findAllEducacion();
    EducacionDTO findEducacionById(Long id);
    EducacionDTO saveEducacion(EducacionDTO educacionDTO);
    EducacionDTO updateEducación(Long id, EducacionDTO educacionDTO);
    void deleteEducacion(Long id);
}
