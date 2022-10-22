package com.yoprogramo.portfoliobackend.service;

import com.yoprogramo.portfoliobackend.model.Persona;
import com.yoprogramo.portfoliobackend.repository.IPersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService implements IPersonaService{
    @Autowired
    private IPersonaRepository repo;

    @Override
    public List<Persona> findAllPersonas() {
        return repo.findAll();
    }

    @Override
    public Persona findPersonaById(Long id) {
        return repo.findById(id)
                .orElse(null);
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
        Persona updatePersona = findPersonaById(id);
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
}
