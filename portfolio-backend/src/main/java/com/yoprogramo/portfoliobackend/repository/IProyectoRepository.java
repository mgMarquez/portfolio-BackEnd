package com.yoprogramo.portfoliobackend.repository;

import com.yoprogramo.portfoliobackend.model.Educacion;
import com.yoprogramo.portfoliobackend.model.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProyectoRepository extends JpaRepository<Proyecto, Long> {
    List<Proyecto> findByPersonaId(long personaId);
}
