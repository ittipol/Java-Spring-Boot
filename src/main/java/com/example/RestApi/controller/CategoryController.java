package com.example.RestApi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/category")
public class CategoryController {
    
    @GetMapping("/")
    public ResponseEntity<?> getCategory() {
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

}
