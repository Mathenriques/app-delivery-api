package com.deliveryapp.aplicativo_delivery.presentation.controllers;

import com.deliveryapp.aplicativo_delivery.application.exceptions.FailedCreateUserException;
import com.deliveryapp.aplicativo_delivery.application.services.UserService;
import com.deliveryapp.aplicativo_delivery.domain.models.User;
import com.deliveryapp.aplicativo_delivery.presentation.dtos.UserDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;
    
    @GetMapping
    protected ResponseEntity<List<UserDTO>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping
    protected ResponseEntity<UserDTO> saveUser(@Valid @RequestBody User user) throws Exception {
        UserDTO response = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
