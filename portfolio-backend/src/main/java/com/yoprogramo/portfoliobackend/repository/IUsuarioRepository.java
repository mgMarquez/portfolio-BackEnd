package com.yoprogramo.portfoliobackend.repository;

import com.yoprogramo.portfoliobackend.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {
}
