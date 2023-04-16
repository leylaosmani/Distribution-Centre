package com.example.distributioncentre.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.distributioncentre.model.Item;

import jakarta.transaction.Transactional;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long>{
    Iterable<Item> findAllByName (String name);
    Iterable<Item> findItemByBrandNameAndName (Item.Brands brand, String name);
    @Transactional
    void deleteItemByDistributionCentreIdAndId (Long idDistribution, Long id);

}
