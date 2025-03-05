package com.sarvikatech.product_service.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "products")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Product {
	@Id
    private String id;
    private String name;
    private String description;
    private double price;
}
