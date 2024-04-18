package com.Aradhya.ProductService.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.Aradhya.ProductService.DTO.ProductRequest;
import com.Aradhya.ProductService.DTO.ProductResponse;
import com.Aradhya.ProductService.Service.productService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product")
public class ProductController {
	private final productService service;
	
	@PostMapping(path = "/create")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void createProduct(@RequestBody ProductRequest req) {
		service.createProduct(req);
		
	}
	
	@GetMapping(path="/")
	@ResponseStatus(code = HttpStatus.OK)
	public List<ProductResponse> getAllProducts(){
		return service.getAllProducts();
	}
}
