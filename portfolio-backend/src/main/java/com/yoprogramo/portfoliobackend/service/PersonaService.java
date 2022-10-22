package com.yoprogramo.portfoliobackend.service;

import com.yoprogramo.portfoliobackend.dto.PersonaDTO;
import com.yoprogramo.portfoliobackend.model.Persona;
import com.yoprogramo.portfoliobackend.repository.IPersonaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
                .toList();
    }

    @Override
    public PersonaDTO findPersonaById(Long id) {
        Persona persona = repo
                .findById(id)
                .orElse(null);
        return mapearDTO(persona);
    }

    @Override
    public void savePersona(Persona persona) {
        repo.save(persona);
    }

    @Override
    public void deletePersona(Long id) {
        repo.deleteById(id);
    }

    @Override
    public void updatePersona(Long id, Persona persona) {
        Persona updatePersona = repo
                .findById(id)
                .orElse(null);
        updatePersona.setNombre(persona.getNombre());
        updatePersona.setApellido(persona.getApellido());
        updatePersona.setFechaNac(persona.getFechaNac());
        updatePersona.setProfesion(persona.getProfesion());
        updatePersona.setNacionalidad(persona.getNacionalidad());
        updatePersona.setUbicacion(persona.getUbicacion());
        updatePersona.setAcercaDe(persona.getAcercaDe());
        updatePersona.setEmail(persona.getEmail());
        updatePersona.setTelefono(persona.getTelefono());
        updatePersona.setFotoUrl(persona.getFotoUrl());
        updatePersona.setBannerUrl(persona.getBannerUrl());

        repo.save(updatePersona);
    }
    private PersonaDTO mapearDTO(Persona persona) {
        return modelMapper.map(persona, PersonaDTO.class);
    }
}
