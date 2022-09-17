package com.yoprogramo.portfoliobackend.service;

import java.util.List;

import com.yoprogramo.portfoliobackend.model.Experiencia;

public interface IExperienciaService {
    List<Experiencia> findAllExperiencias();
    Experiencia findExperienciaById(Long id);
    void saveExperiencia(Experiencia experiencia);
    void deleteExperiencia(Long id);
    void updateExperiencia(Long id, Experiencia experiencia);
}
