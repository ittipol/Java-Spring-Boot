package com.example.RestApi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="products", uniqueConstraints = @UniqueConstraint(columnNames = {"slug"}))
public class Product {
    
    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String slug;

    @Column(nullable = false)
    private String name;

    private int quantity;

    private double price;
    
}
