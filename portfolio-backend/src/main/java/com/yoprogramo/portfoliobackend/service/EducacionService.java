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
    public EducacionDTO saveEducacion(EducacionDTO educacionDTO) {
        Educacion educacion = mapearEntidad(educacionDTO);
        Educacion educacionActualizada = repo.save(educacion);
        return mapearDTO(educacionActualizada);
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
    public EducacionDTO updateEducación(Long id, EducacionDTO educacionDTO) {
        Educacion educacion = repo.findById(id)
                .orElse(null);
        educacion.setTitulo(educacionDTO.getTitulo());
        educacion.setEscuela(educacionDTO.getEscuela());
        educacion.setDescripcion(educacionDTO.getDescripcion());
        educacion.setImgUrl(educacionDTO.getImgUrl());
        educacion.setWebUrl(educacionDTO.getWebUrl());
        educacion.setInicio(educacionDTO.getInicio());
        educacion.setFin(educacionDTO.getFin());

        Educacion educacionActualizado = repo.save(educacion);
        return mapearDTO(educacionActualizado);
    }

    private EducacionDTO mapearDTO(Educacion educacion) {
        return modelMapper.map(educacion, EducacionDTO.class);
    }

    private Educacion mapearEntidad(EducacionDTO educacionDTO) {
        return modelMapper.map(educacionDTO, Educacion.class);
    }
}
