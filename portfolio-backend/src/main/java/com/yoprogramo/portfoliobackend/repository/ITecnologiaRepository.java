package com.yoprogramo.portfoliobackend.repository;

import com.yoprogramo.portfoliobackend.model.Tecnologia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ITecnologiaRepository extends JpaRepository<Tecnologia, Long> {
    List<Tecnologia> findByPersonaId(long personaId);
}
