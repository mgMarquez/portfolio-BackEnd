package com.yoprogramo.portfoliobackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.yoprogramo.portfoliobackend.model.Experiencia;
import com.yoprogramo.portfoliobackend.service.IExperienciaService;

import java.util.List;


@RestController
@RequestMapping("api/v1/experiencia")
public class ExperienciaController {
    @Autowired
    private IExperienciaService service;

    @GetMapping("/")
    public List<Experiencia> getAllExperiencias() {
        return service.findAllExperiencias();
    }

    @GetMapping("/{id}")
    public Experiencia getExperienciaById(@PathVariable Long id) {
        return service.findExperienciaById(id);
    }

    @PostMapping("/new")
    public void addExperiencia(@RequestBody Experiencia experiencia) {
        service.saveExperiencia(experiencia);
    }

    @PutMapping("/{id}")
    public void modifyExperiencia(@PathVariable Long id, @RequestBody Experiencia experiencia) {
        service.updateExperiencia(id, experiencia);
    }
}
