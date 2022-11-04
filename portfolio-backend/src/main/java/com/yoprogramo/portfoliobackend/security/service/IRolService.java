package com.yoprogramo.portfoliobackend.security.service;

import com.yoprogramo.portfoliobackend.security.entity.Rol;
import com.yoprogramo.portfoliobackend.security.enums.RolTipo;

import java.util.Optional;

public interface IRolService {
    Optional<Rol> getByRolNombre(RolTipo rolTipo);
    void save(Rol rol);
}
