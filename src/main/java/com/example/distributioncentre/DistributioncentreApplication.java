package com.example.distributioncentre;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.example.distributioncentre.model.DistributionCentre;
import com.example.distributioncentre.repository.DistributionCentreRepository;
import com.example.distributioncentre.repository.ItemRepository;
import com.example.distributioncentre.repository.UserRepository;
import com.example.distributioncentre.model.Item;
import com.example.distributioncentre.model.User;
import com.example.distributioncentre.model.Item.Brands;

@SpringBootApplication
public class DistributioncentreApplication {

	public static void main(String[] args) {
		SpringApplication.run(DistributioncentreApplication.class, args);
	}

	@Bean
	public CommandLineRunner dataLoader(DistributionCentreRepository repository, ItemRepository repository1, UserRepository repository2, PasswordEncoder passwordEncoder){
		return args ->{
			repository.save(DistributionCentre.builder()
			.name("Sherway")
			.item("Dress")
			.available(150)
			.longitude(200)
			.latitude(100).build());

			repository1.save(Item.builder()
			.name("Dress")
			.brand(Brands.CHANEL)
			.price(150)
			.quantity(200).build());
			
			repository2.save(User.builder()
			.username("admin")
			.password(passwordEncoder.encode("admin")).build());
		};
	}
}
