package com.sarvikatech.product_service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sarvikatech.product_service.entity.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

}
