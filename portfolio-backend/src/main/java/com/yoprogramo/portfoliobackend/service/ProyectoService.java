package com.yoprogramo.portfoliobackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yoprogramo.portfoliobackend.model.Proyecto;
import com.yoprogramo.portfoliobackend.repository.IProyectoRepository;

@Service
public class ProyectoService implements IProyectoService{
    @Autowired
    private IProyectoRepository repo;
    
    @Override
    public List<Proyecto> findAllProyectos() {
        return repo.findAll();
    }

    @Override
    public Proyecto findProyectoById(Long id) {
        return repo.findById(id)
                .orElse(null);
    }

    @Override
    public void saveProyecto(Proyecto proyecto) {
        repo.save(proyecto);        
    }

    @Override
    public void deleteProyecto(Long id) {
        repo.deleteById(id);        
    }

    @Override
    public void updateProyecto(Long id, Proyecto proyecto) {
        Proyecto updateProyecto = findProyectoById(id);
        updateProyecto.setTitulo(proyecto.getTitulo());        
        updateProyecto.setDescripcion(proyecto.getDescripcion());
        updateProyecto.setImg(proyecto.getImg());
        updateProyecto.setUrl(proyecto.getUrl());

        saveProyecto(updateProyecto);
    }
    
}
