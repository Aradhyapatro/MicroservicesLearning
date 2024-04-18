package com.Aradhya.ProductService.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.Aradhya.ProductService.DTO.ProductRequest;
import com.Aradhya.ProductService.DTO.ProductResponse;
import com.Aradhya.ProductService.Model.Product;
import com.Aradhya.ProductService.Repository.ProductRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class productService {

	private final ProductRepository productRepo;
	
	public void createProduct(ProductRequest productRequest) {
		Product product = Product.builder()
				.name(productRequest.getName())
				.description(productRequest.getDescription())
				.price(productRequest.getPrice())
				.build();
		
		productRepo.save(product);
		log.info("Product {} is Added",product.getId());
	}
	
	public List<ProductResponse> getAllProducts() {
		List<Product> products=productRepo.findAll();
		
		return products.stream().map(product->mapToProductResponse(product)).collect(Collectors.toList());
	}

	private ProductResponse mapToProductResponse(Product product) {
		return ProductResponse.builder()
				.id(product.getId())
				.name(product.getName())
				.description(product.getDescription())
				.price(product.getPrice())
				.build();
	}
	
}
