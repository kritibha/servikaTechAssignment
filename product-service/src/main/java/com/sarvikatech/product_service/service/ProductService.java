package com.sarvikatech.product_service.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sarvikatech.product_service.dto.ProductDto;
import com.sarvikatech.product_service.dto.ProductResponse;
import com.sarvikatech.product_service.entity.Product;
import com.sarvikatech.product_service.repository.ProductRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductService {

	@Autowired
	private ProductRepository productRepo;
	
	public void createProduct(ProductDto productDto) { 
		Product product = Product.builder().name(productDto.getName())
				.description(productDto.getDescription())
				.price(productDto.getPrice()).build();
		productRepo.save(product);
		log.info("Product {} is saved successfully.", product.getName());
	}

	public List<ProductResponse> getAllProducts() {
		List<Product> productList = productRepo.findAll();
		
		List<ProductResponse> productResp = productList.stream()
				.map(p -> mapToRroductResponse(p)).toList();
		return productResp;
	}

	private ProductResponse mapToRroductResponse(Product p) {
		return ProductResponse.builder()
				.id(p.getId())
				.name(p.getName())
				.description(p.getDescription())
				.price(p.getPrice()).build();
	}

}
