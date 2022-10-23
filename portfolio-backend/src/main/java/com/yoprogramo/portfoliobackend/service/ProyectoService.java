package com.yoprogramo.portfoliobackend.service;

import java.util.List;

import com.yoprogramo.portfoliobackend.dto.ProyectoDTO;
import com.yoprogramo.portfoliobackend.model.Persona;
import com.yoprogramo.portfoliobackend.repository.IPersonaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yoprogramo.portfoliobackend.model.Proyecto;
import com.yoprogramo.portfoliobackend.repository.IProyectoRepository;

@Service
public class ProyectoService implements IProyectoService{
    @Autowired
    private IProyectoRepository repo;
    @Autowired
    private IPersonaRepository personaRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ProyectoDTO> findAllProyectos(Long personaId) {
        List<Proyecto> proyectos = repo.findByPersonaId(personaId);

        return proyectos
                .stream()
                .map(this::mapearDTO)
                .toList();
    }

    @Override
    public ProyectoDTO findProyectoById(Long id, Long personaId) {
        Proyecto proyecto = repo.findById(id).orElse(null);
        Persona persona = personaRepository.findById(personaId).orElse(null);

        return mapearDTO(proyecto);
    }

    @Override
    public ProyectoDTO saveProyecto(ProyectoDTO proyectoDTO, Long personaId) {
        Proyecto proyecto = mapearEntidad(proyectoDTO);
        Persona persona = personaRepository.findById(personaId).orElse(null);

        proyecto.setPersona(persona);

        Proyecto nuevoProyecto = repo.save(proyecto);
        return mapearDTO(nuevoProyecto);
    }

    @Override
    public ProyectoDTO updateProyecto(Long id, ProyectoDTO proyectoDTO, Long personaId) {
        Proyecto proyecto = repo.findById(id).orElse(null);
        Persona persona = personaRepository.findById(personaId).orElse(null);

        proyecto.setTitulo(proyectoDTO.getTitulo());
        proyecto.setDescripcion(proyectoDTO.getDescripcion());
        proyecto.setImgUrl(proyectoDTO.getImgUrl());
        proyecto.setWebUrl(proyectoDTO.getWebUrl());

        Proyecto proyectoActualizado = repo.save(proyecto);

        return mapearDTO(proyectoActualizado);
    }

    @Override
    public void deleteProyecto(Long id, Long personaId) {
        Persona persona = personaRepository.findById(personaId).orElse(null);

        repo.deleteById(id);
    }

    private ProyectoDTO mapearDTO(Proyecto proyecto) {
        return modelMapper.map(proyecto, ProyectoDTO.class);
    }

    private Proyecto mapearEntidad(ProyectoDTO proyectoDTO) {
        return modelMapper.map(proyectoDTO, Proyecto.class);
    }
}
