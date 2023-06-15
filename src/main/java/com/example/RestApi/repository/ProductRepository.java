package com.example.RestApi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.RestApi.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {

    List<Product> findByName(String name);

    @Query("SELECT p FROM Product p WHERE p.slug = ?1")
    Product findBySlug(String slug);
    
}