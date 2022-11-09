package com.yoprogramo.portfoliobackend.controller;

import com.yoprogramo.portfoliobackend.dto.ProyectoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.yoprogramo.portfoliobackend.service.IProyectoService;

import java.util.List;

@RestController
@RequestMapping("api")
public class ProyectoController {
    @Autowired
    private IProyectoService service;

    @GetMapping("/personas/{persona_id}/proyectos")
    public List<ProyectoDTO> getAllProyectos(@PathVariable Long persona_id) {
        return service.findAllProyectos(persona_id);
    }

    @GetMapping("/personas/{persona_id}/proyectos/{id}")
    public ProyectoDTO getProyectoById(@PathVariable Long id,
                                       @PathVariable Long persona_id) {
        return service.findProyectoById(id, persona_id);
    }

    @PostMapping("/personas/{persona_id}/proyectos")
    public ProyectoDTO addProyecto(@RequestBody ProyectoDTO proyectoDTO,
                                   @PathVariable Long persona_id) {
        return service.saveProyecto(proyectoDTO, persona_id);
    }

    @PutMapping("/personas/{persona_id}/proyectos/{id}")
    public ProyectoDTO modifyProyecto(@PathVariable Long id,
                                      @RequestBody ProyectoDTO proyectoDTO,
                                      @PathVariable Long persona_id) {
        return service.updateProyecto(id, proyectoDTO, persona_id);
    }

    @DeleteMapping("/personas/{persona_id}/proyectos/{id}")
    public void deleteProyecto(@PathVariable Long id,
                               @PathVariable Long persona_id) {
        service.deleteProyecto(id, persona_id);
    }
}
