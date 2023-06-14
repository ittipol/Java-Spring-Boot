package com.example.RestApi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {
 
    @GetMapping("/health")
    public String health(){
        return "ok";
    }

}
