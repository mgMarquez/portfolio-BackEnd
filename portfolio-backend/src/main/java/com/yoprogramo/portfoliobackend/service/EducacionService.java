package com.yoprogramo.portfoliobackend.service;

import com.yoprogramo.portfoliobackend.dto.EducacionDTO;
import com.yoprogramo.portfoliobackend.model.Educacion;
import com.yoprogramo.portfoliobackend.repository.IEduacionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducacionService implements IEducacionService {
    @Autowired
    private IEduacionRepository repo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<EducacionDTO> findAllEducacion() {
        List<Educacion> educaciones = repo.findAll();
        return educaciones.stream()
                .map(educacion -> mapearDTO(educacion))
                .toList();
    }

    @Override
    public void saveEducacion(Educacion educacion) {
        repo.save(educacion);
    }

    @Override
    public EducacionDTO findEducacionById(Long id) {
        Educacion educacion = repo.findById(id)
                .orElse(null);
        return mapearDTO(educacion);
    }

    @Override
    public void deleteEducacion(Long id) {
        Educacion educacion = repo.findById(id)
                .orElse(null);
        repo.delete(educacion);
    }

    @Override
    public void updateEducación(Long id, Educacion educacion) {
        Educacion updateEducacion = repo.findById(id)
                .orElse(null);
        updateEducacion.setTitulo(educacion.getTitulo());
        updateEducacion.setEscuela(educacion.getEscuela());
        updateEducacion.setDescripcion(educacion.getEscuela());
        updateEducacion.setImgUrl(educacion.getImgUrl());
        updateEducacion.setInicio(educacion.getInicio());
        updateEducacion.setFin(educacion.getFin());

        saveEducacion(updateEducacion);
    }

    private EducacionDTO mapearDTO(Educacion educacion) {
        return modelMapper.map(educacion, EducacionDTO.class);
    }
}
