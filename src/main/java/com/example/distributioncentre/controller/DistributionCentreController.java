package com.example.distributioncentre.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.distributioncentre.model.DistributionCentre;
import com.example.distributioncentre.model.dto.CreateDistributionC;
import com.example.distributioncentre.repository.DistributionCentreRepository;

import jakarta.validation.Valid;

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
    @PostMapping
    public DistributionCentre createItem(@Valid @RequestBody CreateDistributionC dc) {
        return distributionCentreRepository.save(dc.toCreateDistributionC());
    }

    @DeleteMapping("/{id}")
    public void deleteDistributionCentre(@PathVariable("id") Long id) {
        distributionCentreRepository.deleteById(id);
    }
}
