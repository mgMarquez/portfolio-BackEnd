package com.yoprogramo.portfoliobackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yoprogramo.portfoliobackend.model.Experiencia;
import com.yoprogramo.portfoliobackend.repository.IExperienciaRepository;

@Service
public class ExperienciaService implements IExperienciaService{
    @Autowired
    private IExperienciaRepository repo;

    @Override
    public List<Experiencia> findAllExperiencias() {
        return repo.findAll();
    }

    @Override
    public void saveExperiencia(Experiencia experiencia) {
        repo.save(experiencia);        
    }

    @Override
    public Experiencia findExperienciaById(Long id) {
        return repo.findById(id)
                .orElse(null);
    }

    @Override
    public void deleteExperiencia(Long id) {
        repo.deleteById(id);        
    }

    @Override
    public void updateExperiencia(Long id, Experiencia experiencia) {
        Experiencia updateExperiencia = findExperienciaById(id);
        updateExperiencia.setPosicion(experiencia.getPosicion());
        updateExperiencia.setCompania(experiencia.getCompania());
        updateExperiencia.setDescripcion(experiencia.getDescripcion());
        updateExperiencia.setImgUrl(experiencia.getImgUrl());
        updateExperiencia.setWebUrl(experiencia.getWebUrl());
        updateExperiencia.setInicio(experiencia.getInicio());
        updateExperiencia.setFin(experiencia.getFin());

        saveExperiencia(updateExperiencia);
    }
    
}
