package com.yoprogramo.portfoliobackend.service;

import com.yoprogramo.portfoliobackend.dto.UsuarioDTO;
import com.yoprogramo.portfoliobackend.model.Usuario;

import java.util.List;

public interface IUsuarioService {
    List<UsuarioDTO> findAllUsuarios();
    Usuario findUsuarioById(Long id);
    void saveUsuario(Usuario usuario);
    void deleteUsuario(Long id);
    void updateUsuario(Long id, Usuario usuario);
}
