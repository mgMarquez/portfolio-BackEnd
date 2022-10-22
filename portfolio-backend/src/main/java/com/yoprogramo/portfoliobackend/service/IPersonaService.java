package com.yoprogramo.portfoliobackend.service;

import com.yoprogramo.portfoliobackend.dto.PersonaDTO;

import java.util.List;

public interface IPersonaService {
    List<PersonaDTO> findAllPersonas();
    PersonaDTO findPersonaById(Long id);
    PersonaDTO savePersona(PersonaDTO personaDTO);
    PersonaDTO updatePersona(Long id, PersonaDTO personaDTO);
    void deletePersona(Long id);

}
