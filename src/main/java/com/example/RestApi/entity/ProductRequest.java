package com.example.RestApi.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductRequest {
    private int id;
    private String name;
    private int quantity;
    private double price;
}
