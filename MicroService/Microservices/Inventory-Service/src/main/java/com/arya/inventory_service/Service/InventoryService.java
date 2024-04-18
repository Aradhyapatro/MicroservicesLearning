package com.arya.inventory_service.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arya.inventory_service.DTO.InventoryResponse;
import com.arya.inventory_service.Repository.InventoryRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class InventoryService {
	@Autowired
	private InventoryRepository repo;

	public List<InventoryResponse> isInStock(List<String> skucode) {
		
		return repo.findBySkucodeIn(skucode).stream()
							.map(a->
								InventoryResponse.builder()
									.skucode(a.getSkucode())
									.isInStock(a.getQuantity()>0)
									.build())
							.toList();
	}

}
