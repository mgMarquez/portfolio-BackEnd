package com.yoprogramo.portfoliobackend.controller;

import java.util.List;

import com.yoprogramo.portfoliobackend.dto.EducacionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.yoprogramo.portfoliobackend.service.IEducacionService;

@RestController
@RequestMapping("api")
public class EducacionController {
    @Autowired
    private IEducacionService service;

    @GetMapping("/personas/{id_persona}/educaciones")
    public List<EducacionDTO> getAllEducacion() {
        return service.findAllEducacion();
    }

    @GetMapping("/personas/{id_persona}/educaciones/{id}")
    public EducacionDTO getEducacionById(@PathVariable Long id, @PathVariable Long id_persona) {
        return service.findEducacionById(id, id_persona);
    }

    @PostMapping("/personas/{id_persona}/educaciones")
    public EducacionDTO addEducacion(@RequestBody EducacionDTO educacionDTO, @PathVariable Long id_persona) {
        return service.saveEducacion(educacionDTO, id_persona);
    }

    @PutMapping("/personas/{id_persona}/educaciones/{id}")
    public EducacionDTO modifyEducacion(@PathVariable Long id, @RequestBody EducacionDTO educacionDTO) {
        return service.updateEducación(id, educacionDTO);
    }

    @DeleteMapping("/personas/{id_persona}/educaciones/{id}")
    public void deleteEducacion(@PathVariable Long id) {
        service.deleteEducacion(id);
    }
}
