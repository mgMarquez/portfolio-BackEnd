package com.yoprogramo.portfoliobackend.service;

import java.util.List;

import com.yoprogramo.portfoliobackend.dto.ExperienciaDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yoprogramo.portfoliobackend.model.Experiencia;
import com.yoprogramo.portfoliobackend.repository.IExperienciaRepository;

@Service
public class ExperienciaService implements IExperienciaService{
    @Autowired
    private IExperienciaRepository repo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ExperienciaDTO> findAllExperiencias() {
        List<Experiencia> experiencias = repo.findAll();
        return experiencias
                .stream()
                .map(this::mapearDTO)
                .toList();
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

    private ExperienciaDTO mapearDTO(Experiencia experiencia) {
        return modelMapper.map(experiencia, ExperienciaDTO.class);
    }
}
