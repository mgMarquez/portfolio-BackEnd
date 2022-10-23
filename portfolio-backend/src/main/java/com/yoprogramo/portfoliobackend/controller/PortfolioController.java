package com.yoprogramo.portfoliobackend.controller;

import com.yoprogramo.portfoliobackend.dto.PortfolioDTO;
import com.yoprogramo.portfoliobackend.service.IPortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/portfolio")
public class PortfolioController {
    @Autowired
    private IPortfolioService portfolioService;

    @GetMapping("/personas/{persona_id}")
    public PortfolioDTO obtenerPortfolio(@PathVariable Long persona_id) {
        return portfolioService.obtenerPorfolio(persona_id);
    }
}
