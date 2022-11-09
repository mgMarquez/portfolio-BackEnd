package com.yoprogramo.portfoliobackend.service;

import com.yoprogramo.portfoliobackend.dto.PortfolioDTO;
import com.yoprogramo.portfoliobackend.model.Persona;
import com.yoprogramo.portfoliobackend.repository.IPersonaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PortfolioService implements IPortfolioService{
    @Autowired
    private IPersonaRepository personaRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public PortfolioDTO obtenerPorfolio(Long personaId) {
        Persona persona = personaRepository.findById(personaId).orElse(null);

        return modelMapper.map(persona, PortfolioDTO.class);
    }
}
