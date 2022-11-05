package com.yoprogramo.portfoliobackend.controller;

import com.yoprogramo.portfoliobackend.dto.UsuarioDTO;
import com.yoprogramo.portfoliobackend.security.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/usuarios")
public class UsuarioController {
    @Autowired
    private IUsuarioService service;

    @GetMapping
    public List<UsuarioDTO> getAllUsuarios() {
        return service.findAllUsuarios();
    }

    @GetMapping("/{id}")
    public UsuarioDTO getUsuarioById(@PathVariable Long id) {
        return service.findUsuarioById(id);
    }

    @PostMapping("/personas/{persona_id}")
    public UsuarioDTO addUsuario(@RequestBody UsuarioDTO usuarioDTO, @PathVariable Long persona_id) {
        return service.saveUsuario(usuarioDTO, persona_id);
    }

    @PutMapping("/{id}/personas/{persona_id}")
    public UsuarioDTO modifyUsuario(@PathVariable Long id, @RequestBody UsuarioDTO usuarioDTO, @PathVariable Long persona_id) {
        return service.updateUsuario(id, usuarioDTO, persona_id);
    }

    @DeleteMapping("/{id}")
    public void deleteUsuario(@PathVariable Long id) {
        service.deleteUsuario(id);
    }
}
