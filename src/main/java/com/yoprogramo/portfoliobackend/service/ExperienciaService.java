package com.yoprogramo.portfoliobackend.service;

import java.util.List;
import java.util.stream.Collectors;

import com.yoprogramo.portfoliobackend.dto.ExperienciaDTO;
import com.yoprogramo.portfoliobackend.model.Persona;
import com.yoprogramo.portfoliobackend.repository.IPersonaRepository;
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
    private IPersonaRepository personaRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ExperienciaDTO> findAllExperiencias(Long personaId) {
        List<Experiencia> experiencias = repo.findByPersonaId(personaId);
        return experiencias
                .stream()
                .map(this::mapearDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ExperienciaDTO saveExperiencia(ExperienciaDTO experienciaDTO, Long personaId) {
        Experiencia experiencia = mapearEntidad(experienciaDTO);
        Persona persona = personaRepository.findById(personaId).orElse(null);
        experiencia.setPersona(persona);

        Experiencia nuevaExperiencia = repo.save(experiencia);
        return mapearDTO(nuevaExperiencia);
    }

    @Override
    public ExperienciaDTO findExperienciaById(Long id, Long personaId) {
        Experiencia experiencia =  repo.findById(id)
                .orElse(null);
        Persona persona = personaRepository.findById(personaId).orElse(null);

        return mapearDTO(experiencia);
    }

    @Override
    public void deleteExperiencia(Long id, Long personaId) {
        repo.deleteById(id);        
    }

    @Override
    public ExperienciaDTO updateExperiencia(Long id, ExperienciaDTO experienciaDTO, Long personaId) {
        Experiencia experiencia = repo.findById(id)
                .orElse(null);
        Persona persona = personaRepository.findById(personaId).orElse(null);

        experiencia.setPosicion(experienciaDTO.getPosicion());
        experiencia.setCompania(experienciaDTO.getCompania());
        experiencia.setDescripcion(experienciaDTO.getDescripcion());
        experiencia.setImgUrl(experienciaDTO.getImgUrl());
        experiencia.setWebUrl(experienciaDTO.getWebUrl());
        experiencia.setInicio(experienciaDTO.getInicio());
        experiencia.setFin(experienciaDTO.getFin());

        Experiencia experienciaActualizada = repo.save(experiencia);
        return mapearDTO(experienciaActualizada);
    }

    private ExperienciaDTO mapearDTO(Experiencia experiencia) {
        return modelMapper.map(experiencia, ExperienciaDTO.class);
    }

    private Experiencia mapearEntidad(ExperienciaDTO experienciaDTO) {
        return modelMapper.map(experienciaDTO, Experiencia.class);
    }
}
