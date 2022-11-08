package com.yoprogramo.portfoliobackend.security.service;

import com.yoprogramo.portfoliobackend.dto.UsuarioDTO;
import com.yoprogramo.portfoliobackend.model.Persona;
import com.yoprogramo.portfoliobackend.model.Usuario;
import com.yoprogramo.portfoliobackend.repository.IPersonaRepository;
import com.yoprogramo.portfoliobackend.security.repository.IUsuarioRepository;
import com.yoprogramo.portfoliobackend.security.service.IUsuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class UsuarioService implements IUsuarioService {
    @Autowired
    private IUsuarioRepository usuarioRepository;
    @Autowired
    private IPersonaRepository personaRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<UsuarioDTO> findAllUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios
                .stream()
                .map(this::mapearDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UsuarioDTO findUsuarioById(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElse(null);
        return mapearDTO(usuario);
    }

    @Override
    public UsuarioDTO saveUsuario(UsuarioDTO usuarioDTO, Long personaId) {
        Persona persona = personaRepo.findById(personaId).orElse(null);
        Usuario usuario = mapearEntidad(usuarioDTO);
        usuario.setPersona(persona);
        Usuario nuevoUsuario = usuarioRepository.save(usuario);
        return mapearDTO(nuevoUsuario);
    }

    @Override
    public void deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public UsuarioDTO updateUsuario(Long id, UsuarioDTO usuarioDTO, Long personaId) {
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        Persona persona = personaRepo.findById(personaId).orElse(null);

        usuario.setNombre(usuarioDTO.getNombre());
        usuario.setContrasenia(usuarioDTO.getContrasenia());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setPersona(persona);

        Usuario usuarioActualizado = usuarioRepository.save(usuario);
        return mapearDTO(usuarioActualizado);
    }

    //
    public Optional<Usuario> getByNombreUsuario(String nombreUsuario) {
        return usuarioRepository.findByNombre(nombreUsuario);
    }

    public boolean existsByNombreUsuario(String nombreUsuario) {
        return usuarioRepository.existsByNombre(nombreUsuario);
    }

    public boolean existsByEmail(String email) {
        return usuarioRepository.existsByEmail(email);
    }

    public void save(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    private UsuarioDTO mapearDTO(Usuario usuario) {
        return modelMapper.map(usuario, UsuarioDTO.class);
    }

    private Usuario mapearEntidad(UsuarioDTO usuarioDTO) {
        return modelMapper.map(usuarioDTO, Usuario.class);
    }
}
