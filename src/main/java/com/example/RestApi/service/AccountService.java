package com.example.RestApi.service;

import java.net.http.HttpClient;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;

@Service
public class AccountService {
    
    public void getAccount() {

        HttpClient httpClient = HttpClient.newHttpClient();
        Gson gson = new Gson();      

    }

    public void addAccount() {

        HttpClient httpClient = HttpClient.newHttpClient();
        Gson gson = new Gson();      

    }

}
