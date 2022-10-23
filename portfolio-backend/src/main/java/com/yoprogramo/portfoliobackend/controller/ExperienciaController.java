package com.yoprogramo.portfoliobackend.controller;

import com.yoprogramo.portfoliobackend.dto.ExperienciaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.yoprogramo.portfoliobackend.service.IExperienciaService;

import java.util.List;

@RestController
@RequestMapping("api")
public class ExperienciaController {
    @Autowired
    private IExperienciaService service;

    @GetMapping("/personas/{persona_id}/experiencias")
    public List<ExperienciaDTO> getAllExperiencias(@PathVariable Long persona_id) {
        return service.findAllExperiencias(persona_id);
    }

    @GetMapping("/personas/{persona_id}/experiencias/{id}")
    public ExperienciaDTO getExperienciaById(@PathVariable Long id,
                                             @PathVariable Long persona_id) {
        return service.findExperienciaById(id, persona_id);
    }

    @PostMapping("/personas/{persona_id}/experiencias")
    public ExperienciaDTO addExperiencia(@RequestBody ExperienciaDTO experienciaDTO,
                                         @PathVariable Long persona_id) {
        return service.saveExperiencia(experienciaDTO, persona_id);
    }

    @PutMapping("/personas/{persona_id}/experiencias/{id}")
    public ExperienciaDTO modifyExperiencia(@PathVariable Long id,
                                            @RequestBody ExperienciaDTO experienciaDTO,
                                            @PathVariable Long persona_id) {
        return service.updateExperiencia(id, experienciaDTO, persona_id);
    }

    @DeleteMapping("/personas/{persona_id}/experiencias/{id}")
    public void deleteExperiencia(@PathVariable Long id,
                                  @PathVariable Long persona_id) {
        service.deleteExperiencia(id, persona_id);
    }
}
