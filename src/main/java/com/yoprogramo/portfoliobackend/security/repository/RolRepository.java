package com.yoprogramo.portfoliobackend.security.repository;

import com.yoprogramo.portfoliobackend.security.entity.Rol;
import com.yoprogramo.portfoliobackend.security.enums.RolTipo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RolRepository extends JpaRepository<Rol, Integer> {
    Optional<Rol> findByRolTipo(RolTipo rolTipo);
}
