package com.example.RestApi.service;

import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.RestApi.entity.CategoryResponse;
import com.example.RestApi.entity.ResponseEntity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Service
public class CategoryService {
    
    public ResponseEntity<List<CategoryResponse>> getCategory() {
        var response = new ResponseEntity<List<CategoryResponse>>();

        HttpClient httpClient = HttpClient.newHttpClient();
        Gson gson = new Gson();        

        Type categoryList = new TypeToken<ArrayList<CategoryResponse>>(){}.getType();
    
        try {
            HttpRequest getRequest = HttpRequest.newBuilder()
            .uri(new URI("http://localhost:4000/category"))
            // .header("Authorization", "Bearer")
            .build();

            HttpResponse<String> getResponse = httpClient.send(getRequest, BodyHandlers.ofString());
            
            // Category[] categories = gson.fromJson(getResponse.body(), Category[].class);
            List<CategoryResponse> categories = gson.fromJson(getResponse.body(), categoryList);

            response.setData(categories);
            response.setHttpStatus(HttpStatus.OK);

        } catch (Exception e) {
            response.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return response;
    }

}
