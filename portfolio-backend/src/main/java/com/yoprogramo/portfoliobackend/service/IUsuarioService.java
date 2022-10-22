package com.yoprogramo.portfoliobackend.service;

import com.yoprogramo.portfoliobackend.dto.UsuarioDTO;

import java.util.List;

public interface IUsuarioService {
    List<UsuarioDTO> findAllUsuarios();
    UsuarioDTO findUsuarioById(Long id);
    UsuarioDTO saveUsuario(UsuarioDTO usuarioDTO, Long personaId);
    UsuarioDTO updateUsuario(Long id, UsuarioDTO usuarioDTO);
    void deleteUsuario(Long id);
}
