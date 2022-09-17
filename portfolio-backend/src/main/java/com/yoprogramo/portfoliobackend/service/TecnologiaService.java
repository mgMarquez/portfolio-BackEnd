package com.yoprogramo.portfoliobackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yoprogramo.portfoliobackend.model.Tecnologia;
import com.yoprogramo.portfoliobackend.repository.ITecnologiaRepository;

@Service
public class TecnologiaService implements ITecnologiaService{
    @Autowired
    private ITecnologiaRepository repo;

    @Override
    public List<Tecnologia> findAllTecnologias() {
        return repo.findAll();
    }

    @Override
    public Tecnologia findTecnologiaById(Long id) {
        return repo.findById(id)
                .orElse(null);
    }

    @Override
    public void saveTecnologia(Tecnologia tecnologia) {
        repo.save(tecnologia);        
    }

    @Override
    public void deleteTecnologia(Long id) {
        repo.deleteById(id);        
    }

    @Override
    public void updateTecnologia(Long id, Tecnologia tecnologia) {
        Tecnologia updateTecnologia = findTecnologiaById(id);
        updateTecnologia.setNombre(tecnologia.getNombre());
        updateTecnologia.setDescripcion(tecnologia.getDescripcion());
        updateTecnologia.setImg(tecnologia.getImg());

        saveTecnologia(updateTecnologia);        
    }
    
}
