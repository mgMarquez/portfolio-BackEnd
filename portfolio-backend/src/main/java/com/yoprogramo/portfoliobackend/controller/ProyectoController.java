package com.yoprogramo.portfoliobackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.yoprogramo.portfoliobackend.model.Proyecto;
import com.yoprogramo.portfoliobackend.service.IProyectoService;

import java.util.List;

@RestController
@RequestMapping("api/v1/proyecto")
public class ProyectoController {
    @Autowired
    private IProyectoService service;

    @GetMapping("/")
    public List<Proyecto> getAllProyectos() {
        return service.findAllProyectos();
    }

    @GetMapping("/{id}")
    public Proyecto getProyectoById(@PathVariable Long id) {
        return service.findProyectoById(id);
    }

    @PostMapping("/new")
    public void addProyecto(@RequestBody Proyecto proyecto) {
        service.saveProyecto(proyecto);
    }

    @PutMapping("/{id}")
    public void modifyProyecto(@PathVariable Long id, @RequestBody Proyecto proyecto) {
        service.updateProyecto(id, proyecto);
    }
}
