package com.yoprogramo.portfoliobackend.service;

import com.yoprogramo.portfoliobackend.dto.PersonaDTO;
import com.yoprogramo.portfoliobackend.model.Persona;

import java.util.List;

public interface IPersonaService {
    List<PersonaDTO> findAllPersonas();
    Persona findPersonaById(Long id);
    void savePersona(Persona persona);
    void deletePersona(Long id);
    void updatePersona(Long id, Persona persona);
}
