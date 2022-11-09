package com.yoprogramo.portfoliobackend.service;

import com.yoprogramo.portfoliobackend.dto.PersonaDTO;
import com.yoprogramo.portfoliobackend.model.Persona;
import com.yoprogramo.portfoliobackend.repository.IPersonaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonaService implements IPersonaService{
    @Autowired
    private IPersonaRepository repo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<PersonaDTO> findAllPersonas() {
        List<Persona> personas = repo.findAll();
        return personas
                .stream()
                .map(this::mapearDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PersonaDTO findPersonaById(Long id) {
        Persona persona = repo
                .findById(id)
                .orElse(null);
        return mapearDTO(persona);
    }

    @Override
    public PersonaDTO savePersona(PersonaDTO personaDTO) {
        Persona persona = mapearEntidad(personaDTO);
        Persona nuevaPersona = repo.save(persona);
        return mapearDTO(nuevaPersona);
    }

    @Override
    public void deletePersona(Long id) {
        repo.deleteById(id);
    }

    @Override
    public PersonaDTO updatePersona(Long id, PersonaDTO personaDTO) {
        Persona updatePersona = repo
                .findById(id)
                .orElse(null);
        updatePersona.setNombre(personaDTO.getNombre());
        updatePersona.setApellido(personaDTO.getApellido());
        updatePersona.setFechaNac(personaDTO.getFechaNac());
        updatePersona.setProfesion(personaDTO.getProfesion());
        updatePersona.setNacionalidad(personaDTO.getNacionalidad());
        updatePersona.setUbicacion(personaDTO.getUbicacion());
        updatePersona.setAcercaDe(personaDTO.getAcercaDe());
        updatePersona.setEmail(personaDTO.getEmail());
        updatePersona.setTelefono(personaDTO.getTelefono());
        updatePersona.setFotoUrl(personaDTO.getFotoUrl());
        updatePersona.setBannerUrl(personaDTO.getBannerUrl());

        Persona personaActualizada = repo.save(updatePersona);
        return mapearDTO(personaActualizada);
    }
    private PersonaDTO mapearDTO(Persona persona) {
        return modelMapper.map(persona, PersonaDTO.class);
    }

    private Persona mapearEntidad(PersonaDTO personaDTO) {
        return modelMapper.map(personaDTO, Persona.class);
    }
}
