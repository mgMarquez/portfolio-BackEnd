package com.yoprogramo.portfoliobackend.controller;

import com.yoprogramo.portfoliobackend.dto.PersonaDTO;
import com.yoprogramo.portfoliobackend.model.Persona;
import com.yoprogramo.portfoliobackend.model.Usuario;
import com.yoprogramo.portfoliobackend.service.IPersonaService;
import com.yoprogramo.portfoliobackend.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/persona")
public class PersonaController {
    @Autowired
    private IPersonaService service;
    @Autowired
    private IUsuarioService serviceUsuario;

    @GetMapping("/")
    public List<Persona> getAllPersonas() {
        return service.findAllPersonas();
    }

    @GetMapping("/{id}")
    public Persona getPersonaById(@PathVariable Long id) {
        return service.findPersonaById(id);
    }

    @PostMapping("/new")
    public void addPersona(@RequestBody PersonaDTO personaDto) {
        Usuario usuario = serviceUsuario.findUsuarioById(personaDto.getUsuario_id());
        Persona nuevaPersona = new Persona();
        //PersonaDto a Persona
        nuevaPersona.setNombre(personaDto.getNombre());
        nuevaPersona.setApellido(personaDto.getApellido());
        nuevaPersona.setFechaNac(personaDto.getFechaNac());
        nuevaPersona.setNacionalidad(personaDto.getNacionalidad());
        nuevaPersona.setUbicacion(personaDto.getUbicacion());
        nuevaPersona.setProfesion(personaDto.getProfesion());
        nuevaPersona.setAcercaDe(personaDto.getAcercaDe());
        nuevaPersona.setTelefono(personaDto.getTelefono());
        nuevaPersona.setEmail(personaDto.getEmail());
        nuevaPersona.setFotoUrl(personaDto.getFotoUrl());
        nuevaPersona.setBannerUrl(personaDto.getBannerUrl());
        nuevaPersona.setUsuario(usuario);

        service.savePersona(nuevaPersona);
    }

    @PutMapping("/{id}")
    public void modifyPersona(@PathVariable Long id, @RequestBody Persona persona) {
        service.updatePersona(id, persona);
    }

    @DeleteMapping("/{id}")
    public void deletePersona(@PathVariable Long id) {
        service.deletePersona(id);
    }
}
