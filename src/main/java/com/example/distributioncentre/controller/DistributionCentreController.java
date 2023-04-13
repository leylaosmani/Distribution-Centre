package com.example.distributioncentre.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.distributioncentre.model.DistributionCentre;
import com.example.distributioncentre.repository.DistributionCentreRepository;

@RestController
@RequestMapping(path = "/api/DistributionCentres", produces = "application/json")
public class DistributionCentreController {
    
    private final DistributionCentreRepository distributionCentreRepository;

    public DistributionCentreController(DistributionCentreRepository distributionCentreRepository){
        this.distributionCentreRepository = distributionCentreRepository;
    }
 
    @GetMapping
    public Iterable<DistributionCentre> allCentres(){
        
        return distributionCentreRepository.findAll();
    }
}
