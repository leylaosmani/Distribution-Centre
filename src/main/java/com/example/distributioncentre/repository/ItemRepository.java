package com.example.distributioncentre.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.distributioncentre.model.Item;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long>{
    
}
