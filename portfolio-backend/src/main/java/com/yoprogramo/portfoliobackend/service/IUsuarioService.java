package com.yoprogramo.portfoliobackend.service;

import com.yoprogramo.portfoliobackend.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IUsuarioService {
    List<Usuario> findAllUsuarios();
    Usuario findUsuarioById(Long id);
    void saveUsuario(Usuario usuario);
    void deleteUsuario(Long id);
    void updateUsuario(Long id, Usuario usuario);
}
