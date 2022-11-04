package com.yoprogramo.portfoliobackend.security.service;

import com.yoprogramo.portfoliobackend.dto.UsuarioDTO;
import com.yoprogramo.portfoliobackend.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface IUsuarioService {
    List<UsuarioDTO> findAllUsuarios();
    UsuarioDTO findUsuarioById(Long id);
    UsuarioDTO saveUsuario(UsuarioDTO usuarioDTO, Long personaId);
    UsuarioDTO updateUsuario(Long id, UsuarioDTO usuarioDTO, Long personaId);
    void deleteUsuario(Long id);

    Optional<Usuario> getByNombreUsuario(String nombreUsuario);
    boolean existsByNombreUsuario(String nombreUsuario);

    boolean existsByEmail(String email);

    void save(Usuario usuario);
}
