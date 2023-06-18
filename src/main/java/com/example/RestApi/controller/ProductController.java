package com.example.RestApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.RestApi.entity.ProductRequest;
import com.example.RestApi.entity.ProductResponse;
import com.example.RestApi.service.ProductService;

@RestController
@RequestMapping("/v1/product")
public class ProductController {
    
    @Autowired
    private ProductService productService;
    
    @PostMapping("")
    public ResponseEntity<ProductResponse> addProduct(@RequestBody ProductRequest product) {
        var result = productService.saveProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @PostMapping("/list")
    public ResponseEntity<List<ProductResponse>> addProducts(@RequestBody List<ProductRequest> products) {
        var result = productService.saveProducts(products);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        var result = productService.getAllProducts();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable int id) {
        var result = productService.getProductById(id);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/slug/{slug}")
    public ResponseEntity<ProductResponse> getProductBySlug(@PathVariable String slug) {
        var result = productService.getProductBySlug(slug); 
        return ResponseEntity.status(result.getHttpStatus()).body(result.getData());
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<ProductResponse>> getProductByName(@PathVariable String name) {
        var result = productService.getProductByName(name); 
        return ResponseEntity.status(result.getHttpStatus()).body(result.getData());
    }

    @PutMapping("")
    public ResponseEntity<ProductResponse> updateProduct(@RequestBody ProductRequest product) {
        var result = productService.updateProduct(product);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}
