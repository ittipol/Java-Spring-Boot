package com.example.RestApi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {
 
    @GetMapping("/health")
    public ResponseEntity<String> health(){
        return ResponseEntity.status(HttpStatus.OK).body("ok");
    }

    @GetMapping("/error")
    public ResponseEntity<String> error(){
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("error");
    }

}
