package com.yoprogramo.portfoliobackend.controller;

import com.yoprogramo.portfoliobackend.dto.PersonaDTO;
import com.yoprogramo.portfoliobackend.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/personas")
public class PersonaController {
    @Autowired
    private IPersonaService service;

    @GetMapping
    public List<PersonaDTO> getAllPersonas() {
        return service.findAllPersonas();
    }

    @GetMapping("/{id}")
    public PersonaDTO getPersonaById(@PathVariable Long id) {
        return service.findPersonaById(id);
    }

    @PostMapping()
    public PersonaDTO addPersona(@RequestBody PersonaDTO personaDTO) {
        return service.savePersona(personaDTO);
    }

    @PutMapping("/{id}")
    public PersonaDTO modifyPersona(@PathVariable Long id, @RequestBody PersonaDTO personaDTO) {
        return service.updatePersona(id, personaDTO);
    }

    @DeleteMapping("/{id}")
    public void deletePersona(@PathVariable Long id) {
        service.deletePersona(id);
    }
}
