package com.yoprogramo.portfoliobackend.security.repository;

import com.yoprogramo.portfoliobackend.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByNombre(String nombreUsuario);
    boolean existsByNombre(String nombreUsuario);
    boolean existsByEmail(String nombreUsuario);
}
