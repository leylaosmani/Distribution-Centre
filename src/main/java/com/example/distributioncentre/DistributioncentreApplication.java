package com.example.distributioncentre;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

import com.example.distributioncentre.model.DistributionCentre;
import com.example.distributioncentre.repository.DistributionCentreRepository;
import com.example.distributioncentre.repository.ItemRepository;
import com.example.distributioncentre.model.Item;
import com.example.distributioncentre.model.Item.Brands;

@EnableMethodSecurity
@SpringBootApplication
public class DistributioncentreApplication {

	public static void main(String[] args) {
		SpringApplication.run(DistributioncentreApplication.class, args);
	}

	@Bean
	public CommandLineRunner dataLoader(DistributionCentreRepository repository, ItemRepository itemRepository){
		return args ->{
			repository.save(new DistributionCentre("Sherway Gardens Mall", "43.6113", "79.5657", 100));
			repository.save(new DistributionCentre("Yorkdale Mall", "43.7259", "79.4521", 40));
			repository.save(new DistributionCentre("Mall of America", "44.8548", "93.2422", 30));
			repository.save(new DistributionCentre("Westfield", "51.5074", "0.2238", 70));

			itemRepository.save(new Item("Dress", Item.Brands.CHANEL, 2022, 1500, 200));
			itemRepository.save(new Item("T-shirt", Brands.PALMANGELS, 2021, 2500, 150));
			itemRepository.save(new Item("Jacket", Brands.STONE_ISLAND, 2023, 2000, 80));
			itemRepository.save(new Item("Sweater", Brands.DIOR, 2022, 1000, 100));
		
			itemRepository.save(new Item("Blazer", Item.Brands.CHANEL, 2022, 2500, 20));
			itemRepository.save(new Item("Sweat-pants", Brands.PALMANGELS, 2021, 500, 200));
			itemRepository.save(new Item("Socks", Brands.STONE_ISLAND, 2023, 80, 120));
			itemRepository.save(new Item("Jeans", Brands.DIOR, 2022, 1500, 90));
		
		
		};
	}
}
