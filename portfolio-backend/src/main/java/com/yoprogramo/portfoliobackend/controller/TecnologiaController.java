package com.yoprogramo.portfoliobackend.controller;

import com.yoprogramo.portfoliobackend.dto.TecnologiaDTO;
import com.yoprogramo.portfoliobackend.service.ITecnologiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class TecnologiaController {
    @Autowired
    private ITecnologiaService service;

    @GetMapping("/personas/{persona_id}/tecnologias")
    public List<TecnologiaDTO> getAllTecnologias(@PathVariable Long persona_id) {
        return service.findAllTecnologias(persona_id);
    }

    @GetMapping("/personas/{persona_id}/tecnologias/{id}")
    public TecnologiaDTO getTecnologiaById(@PathVariable Long id,
                                           @PathVariable Long persona_id) {
        return service.findTecnologiaById(id, persona_id);
    }

    @PostMapping("/personas/{persona_id}/tecnologias")
    public TecnologiaDTO addTecnologia(@RequestBody TecnologiaDTO tecnologiaDTO,
                                       @PathVariable Long persona_id) {
        return service.saveTecnologia(tecnologiaDTO, persona_id);
    }

    @PutMapping("/personas/{persona_id}/tecnologias/{id}")
    public TecnologiaDTO modifyTecnologia(@PathVariable Long id,
                                          @RequestBody TecnologiaDTO tecnologiaDTO,
                                          @PathVariable Long persona_id) {
        return service.updateTecnologia(id, tecnologiaDTO, persona_id);
    }

    @DeleteMapping("/personas/{persona_id}/tecnologias/{id}")
    public void deleteTecnologia(@PathVariable Long id,
                                 @PathVariable Long persona_id) {
        service.deleteTecnologia(id, persona_id);
    }
}
