package com.yoprogramo.portfoliobackend.service;

import java.util.List;
import java.util.stream.Collectors;

import com.yoprogramo.portfoliobackend.dto.TecnologiaDTO;
import com.yoprogramo.portfoliobackend.model.Persona;
import com.yoprogramo.portfoliobackend.repository.IPersonaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yoprogramo.portfoliobackend.model.Tecnologia;
import com.yoprogramo.portfoliobackend.repository.ITecnologiaRepository;

@Service
public class TecnologiaService implements ITecnologiaService{
    @Autowired
    private ITecnologiaRepository repo;
    @Autowired
    private IPersonaRepository personaRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<TecnologiaDTO> findAllTecnologias(Long personaId) {
        List<Tecnologia> tecnologias = repo.findByPersonaId(personaId);
        return tecnologias
                .stream()
                .map(this::mapearDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TecnologiaDTO findTecnologiaById(Long id, Long personaId) {
        Tecnologia tecnologia = repo.findById(id).orElse(null);
        Persona persona = personaRepository.findById(personaId).orElse(null);

        return mapearDTO(tecnologia);
    }

    @Override
    public TecnologiaDTO saveTecnologia(TecnologiaDTO tecnologiaDTO, Long personaId) {
        Tecnologia tecnologia = mapearEntidad(tecnologiaDTO);
        Persona persona = personaRepository.findById(personaId).orElse(null);
        tecnologia.setPersona(persona);

        Tecnologia nuevaTecnologia = repo.save(tecnologia);
        return mapearDTO(nuevaTecnologia);
    }

    @Override
    public TecnologiaDTO updateTecnologia(Long id, TecnologiaDTO tecnologiaDTO, Long personaId) {
        Tecnologia tecnologia = repo.findById(id).orElse(null);
        Persona persona = personaRepository.findById(personaId).orElse(null);

        tecnologia.setNombre(tecnologiaDTO.getNombre());
        tecnologia.setDescripcion(tecnologiaDTO.getDescripcion());
        tecnologia.setImgUrl(tecnologiaDTO.getImgUrl());
        tecnologia.setProgreso(tecnologiaDTO.getProgreso());

        Tecnologia tecnologiaActualizada = repo.save(tecnologia);
        return mapearDTO(tecnologia);
    }

    @Override
    public void deleteTecnologia(Long id, Long personaId) {
        Persona persona = personaRepository.findById(personaId).orElse(null);

        repo.deleteById(id);
    }

    private TecnologiaDTO mapearDTO(Tecnologia tecnologia) {
        return modelMapper.map(tecnologia, TecnologiaDTO.class);
    }

    private  Tecnologia mapearEntidad(TecnologiaDTO tecnologiaDTO) {
        return modelMapper.map(tecnologiaDTO, Tecnologia.class);
    }

}
