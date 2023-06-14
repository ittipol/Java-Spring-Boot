package com.example.RestApi.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductResponse {
    private int id;
    private String slug;
    private String name;
    private int quantity;
    private double price;
}
