package com.yoprogramo.portfoliobackend.repository;

import com.yoprogramo.portfoliobackend.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPersonaRepository extends JpaRepository<Persona, Long> {
}
