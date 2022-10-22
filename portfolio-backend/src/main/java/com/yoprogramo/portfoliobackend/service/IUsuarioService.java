package com.yoprogramo.portfoliobackend.service;

import com.yoprogramo.portfoliobackend.dto.UsuarioDTO;
import com.yoprogramo.portfoliobackend.model.Usuario;

import java.util.List;

public interface IUsuarioService {
    List<UsuarioDTO> findAllUsuarios();
    UsuarioDTO findUsuarioById(Long id);
    UsuarioDTO saveUsuario(UsuarioDTO usuarioDTO);
    void deleteUsuario(Long id);
    void updateUsuario(Long id, Usuario usuario);
}
