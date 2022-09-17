package com.yoprogramo.portfoliobackend.controller;

import com.yoprogramo.portfoliobackend.model.Persona;
import com.yoprogramo.portfoliobackend.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/persona")
public class PersonaController {
    @Autowired
    private IPersonaService service;

    @GetMapping("/")
    public List<Persona> getAllPersonas() {
        return service.findAllPersonas();
    }

    @GetMapping("/{id}")
    public Persona getPersonaById(@PathVariable Long id) {
        return service.findPersonaById(id);
    }

    @PostMapping("/new")
    public void addPersona(@RequestBody Persona persona) {
        service.savePersona(persona);
    }

    @PutMapping("/{id}")
    public void modifyPersona(@PathVariable Long id, @RequestBody Persona persona) {
        service.updatePersona(id, persona);
    }
}
