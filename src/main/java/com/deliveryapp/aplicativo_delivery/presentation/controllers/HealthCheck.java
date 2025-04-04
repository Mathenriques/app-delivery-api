package com.deliveryapp.aplicativo_delivery.presentation.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("health")
public class HealthCheck {

    @GetMapping()
    public ResponseEntity hello() {
        return ResponseEntity.ok("Hello World");
    }
}
