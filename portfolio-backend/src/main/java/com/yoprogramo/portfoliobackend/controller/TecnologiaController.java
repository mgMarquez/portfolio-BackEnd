package com.yoprogramo.portfoliobackend.controller;

import com.yoprogramo.portfoliobackend.model.Tecnologia;
import com.yoprogramo.portfoliobackend.service.ITecnologiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/tecnologia")
public class TecnologiaController {
    @Autowired
    private ITecnologiaService service;

    @GetMapping("/")
    public List<Tecnologia> getAllTecnologias() {
        return service.findAllTecnologias();
    }

    @GetMapping("/{id}")
    public Tecnologia getTecnologiaById(@PathVariable Long id) {
        return service.findTecnologiaById(id);
    }

    @PostMapping("/new")
    public void addTecnologia(@RequestBody Tecnologia tecnologia) {
        service.saveTecnologia(tecnologia);
    }

    @PutMapping("/{id}")
    public void modifyTecnologia(@PathVariable Long id, @RequestBody Tecnologia tecnologia) {
        service.updateTecnologia(id, tecnologia);
    }
}
