package com.yoprogramo.portfoliobackend.service;

import com.yoprogramo.portfoliobackend.dto.EducacionDTO;
import com.yoprogramo.portfoliobackend.model.Educacion;

import java.util.List;

public interface IEducacionService {
    List<EducacionDTO> findAllEducacion();
    EducacionDTO findEducacionById(Long id);
    void saveEducacion(Educacion educacion);
    void deleteEducacion(Long id);
    void updateEducación(Long id, Educacion educacion);
}
