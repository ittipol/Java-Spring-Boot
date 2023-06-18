package com.example.RestApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.RestApi.service.AccountService;

@RestController
@RequestMapping("/v1/account")
public class AccountController {

    @Autowired
    private AccountService accountService;
    
    @GetMapping("")
    public ResponseEntity<?> getAccount() {
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @PostMapping("")
    public ResponseEntity<?> addAccount() {
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

}
