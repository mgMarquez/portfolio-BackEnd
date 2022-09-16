package com.yoprogramo.portfoliobackend.service;

import com.yoprogramo.portfoliobackend.model.Usuario;
import com.yoprogramo.portfoliobackend.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService implements IUsuarioService{
    @Autowired
    private IUsuarioRepository repo;

    @Override
    public List<Usuario> findAllUsuarios() {
        return repo.findAll();
    }

    @Override
    public Usuario findUsuarioById(Long id) {
        return repo.findById(id)
                .orElse(null);
    }

    @Override
    public void saveUsuario(Usuario usuario) {
        repo.save(usuario);
    }

    @Override
    public void deleteUsuario(Long id) {
        repo.deleteById(id);
    }

    @Override
    public void updateUsuario(Long id, Usuario usuario) {
        Usuario updateUsuario = findUsuarioById(id);
        updateUsuario.setNombre(usuario.getNombre());
        updateUsuario.setContrasenia(usuario.getContrasenia());
    }
}
