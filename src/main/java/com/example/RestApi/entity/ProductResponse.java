package com.example.RestApi.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductResponse {
    private int id;
    private String slug;
    private String name;
    private int quantity;
    private double price;
}
