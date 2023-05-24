package com.yoprogramo.portfoliobackend.service;

import com.yoprogramo.portfoliobackend.dto.EducacionDTO;
import com.yoprogramo.portfoliobackend.model.Educacion;
import com.yoprogramo.portfoliobackend.model.Persona;
import com.yoprogramo.portfoliobackend.repository.IEduacionRepository;
import com.yoprogramo.portfoliobackend.repository.IPersonaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EducacionService implements IEducacionService {
    @Autowired
    private IEduacionRepository repo;
    @Autowired
    private IPersonaRepository personaRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<EducacionDTO> findAllEducacion(Long personaId) {
        List<Educacion> educaciones = repo.findByPersonaId(personaId);
        return educaciones.stream()
                .map(this::mapearDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EducacionDTO saveEducacion(EducacionDTO educacionDTO, Long personaId) {
        Persona persona = personaRepo.findById(personaId).orElse(null);
        Educacion educacion = mapearEntidad(educacionDTO);
        educacion.setPersona(persona);
        Educacion educacionActualizada = repo.save(educacion);
        return mapearDTO(educacionActualizada);
    }

    @Override
    public EducacionDTO findEducacionById(Long id, Long personaId) {
        Persona persona = personaRepo.findById(personaId).orElse(null);
        Educacion educacion = repo.findById(id)
                .orElse(null);
        if(!educacion.getPersona().getId().equals(persona.getId())) {
            // exception
        }
        return mapearDTO(educacion);
    }

    @Override
    public void deleteEducacion(Long id, Long personaId) {
        Persona persona = personaRepo.findById(personaId).orElse(null);
        Educacion educacion = repo.findById(id)
                .orElse(null);
        if(educacion.getPersona().getId() != persona.getId()) {
            // exception
        }
        repo.delete(educacion);
    }

    @Override
    public EducacionDTO updateEducacion(Long id, EducacionDTO educacionDTO, Long personaId) {

        Educacion educacion = repo.findById(id)
                .orElse(null);
        Persona persona = personaRepo.findById(personaId).orElse(null);

        if(educacion.getPersona().getId() != persona.getId()) {
            // exception
        }

            educacion.setTitulo(educacionDTO.getTitulo());
        educacion.setEscuela(educacionDTO.getEscuela());
        educacion.setDescripcion(educacionDTO.getDescripcion());
        educacion.setImgUrl(educacionDTO.getImgUrl());
        educacion.setWebUrl(educacionDTO.getWebUrl());
        educacion.setInicio(educacionDTO.getInicio());
        educacion.setFin(educacionDTO.getFin());

        Educacion educacionActualizado = repo.save(educacion);
        return mapearDTO(educacionActualizado);
    }

    private EducacionDTO mapearDTO(Educacion educacion) {
        return modelMapper.map(educacion, EducacionDTO.class);
    }

    private Educacion mapearEntidad(EducacionDTO educacionDTO) {
        return modelMapper.map(educacionDTO, Educacion.class);
    }
}
