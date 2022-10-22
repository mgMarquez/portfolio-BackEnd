package com.yoprogramo.portfoliobackend.service;

import com.yoprogramo.portfoliobackend.dto.UsuarioDTO;
import com.yoprogramo.portfoliobackend.model.Usuario;
import com.yoprogramo.portfoliobackend.repository.IUsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService implements IUsuarioService{
    @Autowired
    private IUsuarioRepository repo;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<UsuarioDTO> findAllUsuarios() {
        List<Usuario> usuarios = repo.findAll();
        return usuarios
                .stream()
                .map(this::mapearDTO)
                .toList();
    }

    @Override
    public UsuarioDTO findUsuarioById(Long id) {
        Usuario usuario = repo.findById(id)
                .orElse(null);
        return mapearDTO(usuario);
    }

    @Override
    public UsuarioDTO saveUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = mapearEntidad(usuarioDTO);
        Usuario nuevoUsuario = repo.save(usuario);
        return mapearDTO(nuevoUsuario);
    }

    @Override
    public void deleteUsuario(Long id) {
        repo.deleteById(id);
    }

    @Override
    public void updateUsuario(Long id, Usuario usuario) {
        Usuario updateUsuario = repo.findById(id).orElse(null);
        updateUsuario.setNombre(usuario.getNombre());
        updateUsuario.setContrasenia(usuario.getContrasenia());
    }

    private UsuarioDTO mapearDTO(Usuario usuario) {
        return modelMapper.map(usuario, UsuarioDTO.class);
    }

    private Usuario mapearEntidad(UsuarioDTO usuarioDTO) {
        return modelMapper.map(usuarioDTO, Usuario.class);
    }
}
