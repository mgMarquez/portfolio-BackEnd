package com.yoprogramo.portfoliobackend.service;

import com.yoprogramo.portfoliobackend.model.Proyecto;

import java.util.List;

public interface IProyectoService {
    List<Proyecto> findAllProyectos();
    Proyecto findProyectoById(Long id);
    void saveProyecto(Proyecto proyecto);
    void deleteProyecto(Long id);
    void updateProyecto(Long id, Proyecto proyecto);
}
