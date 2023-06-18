package com.example.RestApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.RestApi.entity.CategoryResponse;
import com.example.RestApi.service.CategoryService;

@RestController
@RequestMapping("/v1/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    
    @GetMapping("")
    public ResponseEntity<List<CategoryResponse>> getCategory() {
        var result = categoryService.getCategory();
        return ResponseEntity.status(result.getHttpStatus()).body(result.getData());
    }

}
