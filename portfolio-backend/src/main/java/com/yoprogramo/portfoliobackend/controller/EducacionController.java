package com.yoprogramo.portfoliobackend.controller;

import java.util.List;

import com.yoprogramo.portfoliobackend.dto.EducacionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.yoprogramo.portfoliobackend.model.Educacion;
import com.yoprogramo.portfoliobackend.service.IEducacionService;

@RestController
@RequestMapping("api/educaciones")
public class EducacionController {
    @Autowired
    private IEducacionService service;

    @GetMapping("/")
    public List<EducacionDTO> getAllEducacion() {
        return service.findAllEducacion();
    }

    @GetMapping("/{id}")
    public EducacionDTO getEducacionById(@PathVariable Long id) {
        return service.findEducacionById(id);
    }

    @PostMapping("/")
    public void addEducacion(@RequestBody Educacion educacion) {
        service.saveEducacion(educacion);
    }

    @PutMapping("/{id}")
    public void modifyEducacion(@PathVariable Long id, @RequestBody Educacion educacion) {
        service.updateEducación(id, educacion);
    }

    @DeleteMapping("/{id}")
    public void deleteEducacion(@PathVariable Long id) {
        service.deleteEducacion(id);
    }
}
