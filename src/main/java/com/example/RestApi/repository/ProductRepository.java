package com.example.RestApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.RestApi.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {

    Product findByName(String name);
    
}