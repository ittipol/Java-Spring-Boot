package com.example.RestApi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
// @AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(
    name="products", 
    uniqueConstraints = @UniqueConstraint(columnNames = {"slug"})
)
public class Product {
    
    @Id
    @SequenceGenerator(
        name = "products_sequence",
        sequenceName = "products_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE, 
        generator = "products_sequence"
    )
    private int id;

    @Column(nullable = false)
    @NonNull
    private String slug;

    @Column(nullable = false)
    private String name;

    private Integer quantity;

    private Double price;
    
}
