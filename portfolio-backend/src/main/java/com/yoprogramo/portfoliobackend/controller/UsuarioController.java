package com.yoprogramo.portfoliobackend.controller;

import com.yoprogramo.portfoliobackend.model.Usuario;
import com.yoprogramo.portfoliobackend.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/usuario")
public class UsuarioController {
    @Autowired
    private IUsuarioService service;

    @GetMapping("/")
    public List<Usuario> getAllUsuarios() {
        return service.findAllUsuarios();
    }

    @GetMapping("/{id}")
    public Usuario getUsuarioById(@PathVariable Long id) {
        return service.findUsuarioById(id);
    }

    @PostMapping("/new")
    public void addUsuario(@RequestBody Usuario usuario) {
        service.saveUsuario(usuario);
    }

    @PutMapping("/{id}")
    public void modifyUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        service.updateUsuario(id, usuario);
    }

    @DeleteMapping("/{id}")
    public void deleteUsuario(@PathVariable Long id) {
        service.deleteUsuario(id);
    }
}
