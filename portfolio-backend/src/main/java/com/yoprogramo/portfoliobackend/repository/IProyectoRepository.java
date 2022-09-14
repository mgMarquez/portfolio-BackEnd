package com.yoprogramo.portfoliobackend.repository;

import com.yoprogramo.portfoliobackend.model.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProyectoRepository extends JpaRepository<Proyecto, Long> {
}
