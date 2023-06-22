package com.example.RestApi.service;

import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.RestApi.entity.AccountRequest;
import com.example.RestApi.entity.AccountResponse;
import com.example.RestApi.entity.CategoryResponse;
import com.example.RestApi.entity.ResponseEntity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Service
public class AccountService {
    
    public ResponseEntity<List<AccountResponse>> getAccount() {
        var response = new ResponseEntity<List<AccountResponse>>();

        HttpClient httpClient = HttpClient.newHttpClient();
        Gson gson = new Gson();   
        
        Type accountList = new TypeToken<ArrayList<AccountResponse>>(){}.getType();

        try {
            HttpRequest getRequest = HttpRequest.newBuilder()
            .uri(new URI("http://localhost:4000/account"))
            // .header("Authorization", "Bearer")
            .build();

            HttpResponse<String> getResponse = httpClient.send(getRequest, BodyHandlers.ofString());
            // Category[] categories = gson.fromJson(getResponse.body(), Category[].class);
            List<AccountResponse> accounts = gson.fromJson(getResponse.body(), accountList);

            response.setData(accounts);
            response.setHttpStatus(HttpStatus.OK);

        } catch (Exception e) {
            response.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return response;
    }

    public ResponseEntity<AccountResponse> addAccount(AccountRequest account) {

        var response = new ResponseEntity<AccountResponse>();

        HttpClient httpClient = HttpClient.newHttpClient();
        Gson gson = new Gson();      

        try {

            String jsonRequest = gson.toJson(account);

            HttpRequest postRequest = HttpRequest.newBuilder()
            .uri(URI.create("http://localhost:4000/account"))
            // .header("Authorization", "Bearer")
            .header("Content-Type", "application/json")
            .POST(BodyPublishers.ofString(jsonRequest))
            .build();

            HttpResponse<String> postResponse = httpClient.send(postRequest, BodyHandlers.ofString());
            AccountResponse addedAccount = gson.fromJson(postResponse.body(), AccountResponse.class);        

            response.setData(addedAccount);

            if(addedAccount.getId() == 0) {
                response.setHttpStatus(HttpStatus.OK);
            }else {                
                response.setHttpStatus(HttpStatus.CREATED);
            }            

        } catch (Exception e) {
            response.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return response;        
    }

}
