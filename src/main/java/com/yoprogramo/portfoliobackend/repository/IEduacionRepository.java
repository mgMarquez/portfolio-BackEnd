package com.yoprogramo.portfoliobackend.repository;

import com.yoprogramo.portfoliobackend.model.Educacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IEduacionRepository extends JpaRepository <Educacion, Long> {
    List<Educacion> findByPersonaId(long personaId);

}
