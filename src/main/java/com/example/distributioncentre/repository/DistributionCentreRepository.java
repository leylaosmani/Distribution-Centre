package com.example.distributioncentre.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.distributioncentre.model.DistributionCentre;

@Repository
public interface DistributionCentreRepository extends CrudRepository<DistributionCentre, Long>{
    
}
