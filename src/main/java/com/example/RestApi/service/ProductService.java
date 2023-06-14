package com.example.RestApi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.RestApi.entity.Product;
import com.example.RestApi.entity.ProductRequest;
import com.example.RestApi.entity.ProductResponse;
import com.example.RestApi.repository.ProductRepository;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository; 

    public ProductResponse saveProduct(ProductRequest body) {

        String slug = this.genSlug();

        var product = new Product();
        product.setSlug(slug);
        product.setName(body.getName());
        product.setPrice(body.getPrice());
        product.setQuantity(body.getQuantity());

        var result = productRepository.save(product);

        var response = new ProductResponse();
        response.setId(result.getId());
        response.setSlug(result.getSlug());
        response.setName(result.getName());
        response.setPrice(result.getPrice());
        response.setQuantity(result.getQuantity());

        return response;
    }

    public List<ProductResponse> saveProducts(List<ProductRequest> body) {

        List<ProductResponse> response = new ArrayList<ProductResponse>();
        List<Product> products = new ArrayList<Product>();

        body.forEach((data) -> {

            String slug = this.genSlug();
            
            Product product = new Product();
            product.setId(data.getId());
            product.setSlug(slug);
            product.setName(data.getName());
            product.setPrice(data.getPrice());
            product.setQuantity(data.getQuantity());

            products.add(product);

        });
        var result = productRepository.saveAll(products);

        result.forEach((data) -> {
            ProductResponse product = new ProductResponse();
            product.setId(data.getId());
            product.setSlug(data.getSlug());
            product.setName(data.getName());
            product.setPrice(data.getPrice());
            product.setQuantity(data.getQuantity());

            response.add(product);
        });

        return response;
    }

    public List<ProductResponse> getAllProducts() {

        List<ProductResponse> response = new ArrayList<ProductResponse>();

        var result = productRepository.findAll();

        result.forEach((data) -> {
            ProductResponse product = new ProductResponse();
            product.setId(data.getId());
            product.setSlug(data.getSlug());
            product.setName(data.getName());
            product.setPrice(data.getPrice());
            product.setQuantity(data.getQuantity());

            response.add(product);
        });

        return response;
    }

    public ProductResponse getProductById(int id) {
        var result = productRepository.findById(id).orElse(null);

        var response = new ProductResponse();
        response.setId(result.getId());
        response.setSlug(result.getSlug());
        response.setName(result.getName());
        response.setPrice(result.getPrice());
        response.setQuantity(result.getQuantity());

        return response;
    }

    public List<ProductResponse> getProductByName(String name) {

        List<ProductResponse> response = new ArrayList<ProductResponse>();

        var result = productRepository.findByName(name);

        result.forEach((data) -> {
            ProductResponse product = new ProductResponse();
            product.setId(data.getId());
            product.setSlug(data.getSlug());
            product.setName(data.getName());
            product.setPrice(data.getPrice());
            product.setQuantity(data.getQuantity());

            response.add(product);
        });

        return response;
    }

    public ProductResponse updateProduct(ProductRequest product) {

        var existingProduct = productRepository.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setPrice(product.getPrice());

        var updatedProduct = productRepository.save(existingProduct);

        var result = new ProductResponse();
        result.setId(updatedProduct.getId());
        result.setName(updatedProduct.getName());
        result.setPrice(updatedProduct.getPrice());
        result.setQuantity(updatedProduct.getQuantity());

        return result;
    }

    public String deleteProduct(int id) {
        productRepository.deleteById(id);
        return String.format("Product id %s removed", id);
    }

    private String genSlug() {

        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int) 
            (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }

        return buffer.toString();
    }
}
