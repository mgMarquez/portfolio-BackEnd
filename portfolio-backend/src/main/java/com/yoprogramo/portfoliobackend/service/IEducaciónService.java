package com.yoprogramo.portfoliobackend.service;

import com.yoprogramo.portfoliobackend.model.Educacion;

import java.util.List;

public interface IEducaciónService {
    List<Educacion> findAllEducacion();
    void saveEducacion(Educacion educacion);
    Educacion findEducacionById(Long id);
    void deleteEducacion(Long id);
}
