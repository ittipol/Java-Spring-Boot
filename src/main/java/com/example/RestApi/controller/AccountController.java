package com.example.RestApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.RestApi.entity.AccountRequest;
import com.example.RestApi.service.AccountService;

@RestController
@RequestMapping("/v1/account")
public class AccountController {

    @Autowired
    private AccountService accountService;
    
    @GetMapping("")
    public ResponseEntity<?> getAccount() {
        var result = accountService.getAccount();
        return ResponseEntity.status(result.getHttpStatus()).body(result.getData());
    }

    @PostMapping("")
    public ResponseEntity<?> addAccount(@RequestBody AccountRequest account) {
        var result = accountService.addAccount(account);
        return ResponseEntity.status(result.getHttpStatus()).body(result.getData());
    }

}
