package com.example.distributioncentre.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.distributioncentre.model.DistributionCentre;
import com.example.distributioncentre.model.Item;
import com.example.distributioncentre.model.dto.CreateItem;
import com.example.distributioncentre.repository.DistributionCentreRepository;
import com.example.distributioncentre.repository.ItemRepository;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ItemController {
    private final ItemRepository itemRepository;
    private final DistributionCentreRepository distributionCentreRepository;
    public ItemController(ItemRepository itemRepository, DistributionCentreRepository distributionCentreRepository) {
        this.itemRepository = itemRepository;
        this.distributionCentreRepository = distributionCentreRepository;
    }
    @GetMapping
    public Iterable<Item> allItems() {
        return itemRepository.findAll();
    }

    @PostMapping
    public Item createItem(@Valid @RequestBody CreateItem item) {
       return itemRepository.save(item.toItem());
    }

    @DeleteMapping("/{id}/{idDistribution}")
    public void deleteItem(@PathVariable("id") Long id, @PathVariable("idDistribution") Long idDistribution) {
        itemRepository.deleteItemByDistributionCentreIdAndId(idDistribution, id);
    }

    @GetMapping("/{name}")
    public Iterable<Optional<DistributionCentre>> listDCByItem(@PathVariable("name") String name){
        Iterable<Item> items = itemRepository.findAllByName(name);

        List<Optional<DistributionCentre>> listDistribution = new ArrayList<>();
        for(Item item: items){
            Long idDistribution = item.getDistributionId();
            listDistribution.add(distributionCentreRepository.findById(idDistribution));
        }
        List<Optional<DistributionCentre>> DCs = listDistribution;
        return DCs;
    }
    @GetMapping("/distributionC/{name}/{brand}")
    public Iterable<Optional<DistributionCentre>> listDCByNameAndBrand(@PathVariable("name") String name,
                                                             @PathVariable("brand") Item.Brands brand){

        Iterable<Item> items = itemRepository.findItemByBrandNameAndName(brand, name);
        List<Optional<DistributionCentre>> listDCs2 = new ArrayList<>();
        for(Item item: items){
            Long idDistribution = item.getDistributionId();
            listDCs2.add(distributionCentreRepository.findById(idDistribution));
        }
        List<Optional<DistributionCentre>> DCs = listDCs2;
        return DCs;
    }

    @GetMapping("/{name}/{brand}")
    public Iterable<Item> listItemByNameAndBrand(@PathVariable("name") String name,
                                                             @PathVariable("brand") Item.Brands brand){

        return itemRepository.findItemByBrandNameAndName(brand, name);
    }
}
