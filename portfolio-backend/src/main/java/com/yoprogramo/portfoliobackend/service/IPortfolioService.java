package com.yoprogramo.portfoliobackend.service;

import com.yoprogramo.portfoliobackend.dto.PortfolioDTO;

public interface IPortfolioService {
    PortfolioDTO obtenerPorfolio(Long personaId);
}
