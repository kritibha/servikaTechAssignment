package com.sarvikatech.product_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sarvikatech.product_service.dto.ProductDto;
import com.sarvikatech.product_service.dto.ProductResponse;
import com.sarvikatech.product_service.service.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/products")
@Tag(name = "Product Service Management", description = "Operations related to products.")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/all")
	@Operation(summary = "Get All Products", description = "Retrieve all product list.")
	public List<ProductResponse> getAllProducts(){
		return productService.getAllProducts();
	}
	
	@PostMapping("/new")
	@Operation(summary = "Create a new product", description = "Adding a new product to the MongoDB database productdb.")
    public void createProduct(@RequestBody ProductDto productDto) {
        productService.createProduct(productDto);
    }

}
