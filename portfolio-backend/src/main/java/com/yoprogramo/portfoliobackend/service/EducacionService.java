package com.yoprogramo.portfoliobackend.service;

import com.yoprogramo.portfoliobackend.model.Educacion;
import com.yoprogramo.portfoliobackend.repository.IEduacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducacionService implements IEducaciónService {
    @Autowired
    private IEduacionRepository repo;

    @Override
    public List<Educacion> findAllEducacion() {
        return repo.findAll();
    }

    @Override
    public void saveEducacion(Educacion educacion) {
        repo.save(educacion);
    }

    @Override
    public Educacion findEducacionById(Long id) {
        return repo.findById(id)
                .orElse(null);
    }

    @Override
    public void deleteEducacion(Long id) {
        Educacion educacion = findEducacionById(id);
        repo.delete(educacion);
    }

    @Override
    public void updateEducación(Long id, Educacion educacion) {
        Educacion updateEducacion = findEducacionById(id);
        updateEducacion.setTitulo(educacion.getTitulo());
        updateEducacion.setEscuela(educacion.getEscuela());
        updateEducacion.setDescripcion(educacion.getEscuela());
        updateEducacion.setImg(educacion.getImg());
        updateEducacion.setInicio(educacion.getInicio());
        updateEducacion.setFin(educacion.getFin());

        saveEducacion(updateEducacion);
    }
}
