package com.yoprogramo.portfoliobackend.security.service;

import com.yoprogramo.portfoliobackend.security.entity.Rol;
import com.yoprogramo.portfoliobackend.security.enums.RolTipo;
import com.yoprogramo.portfoliobackend.security.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class RolService implements IRolService{
    @Autowired
    private RolRepository rolRepository;

    public Optional<Rol> getByRolNombre(RolTipo rolTipo) {
        return rolRepository.findByRolTipo(rolTipo);
    }

    public void save(Rol rol) {
        rolRepository.save(rol);
    }
}
