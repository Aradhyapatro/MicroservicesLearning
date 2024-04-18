package com.arya.inventory_service.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.arya.inventory_service.DTO.InventoryResponse;
import com.arya.inventory_service.Service.InventoryService;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {
	@Autowired
	private InventoryService inventoryService;

	@GetMapping("")
	@ResponseStatus(code = HttpStatus.OK)
	public List<InventoryResponse> isInStock(@RequestParam List<String> skucode){
		System.out.println(skucode);
		return inventoryService.isInStock(skucode);
	}
}
