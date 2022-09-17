package com.yoprogramo.portfoliobackend.service;

import java.util.List;

import com.yoprogramo.portfoliobackend.model.Tecnologia;

public interface ITecnologiaService {
    List<Tecnologia> findAllTecnologias();
    Tecnologia findTecnologiaById(Long id);
    void saveTecnologia(Tecnologia tecnologia);
    void deleteTecnologia(Long id);
    void updateTecnologia(Long id, Tecnologia tecnologia);
}
