package com.yoprogramo.portfoliobackend.repository;

import com.yoprogramo.portfoliobackend.model.Experiencia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IExperienciaRepository extends JpaRepository<Experiencia, Long> {
    List<Experiencia> findByPersonaId(long personaId);
}
