package com.arya.inventory_service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.arya.inventory_service.Model.Inventory;
import com.arya.inventory_service.Repository.InventoryRepository;

@SpringBootApplication
@EnableDiscoveryClient
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

//	@Bean
	public CommandLineRunner loadData(InventoryRepository Repo) {
		return args -> {
			Inventory inv = new Inventory();
			inv.setSkucode("iphone17");
			inv.setQuantity(25);

			Inventory inv1 = new Inventory();
			inv.setSkucode("motor");
			inv.setQuantity(0);

			Repo.save(inv);
			Repo.save(inv1);
		};
	}

}
