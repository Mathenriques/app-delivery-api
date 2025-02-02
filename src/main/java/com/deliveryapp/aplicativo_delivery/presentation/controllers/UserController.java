package com.deliveryapp.aplicativo_delivery.presentation.controllers;

import com.deliveryapp.aplicativo_delivery.application.services.UserService;
import com.deliveryapp.aplicativo_delivery.domain.models.User;
import com.deliveryapp.aplicativo_delivery.presentation.dtos.UserDTO;
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
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public ResponseEntity<UserDTO> saveUser(@RequestBody User user) {
        User newUser = userService.saveUser(user);
        UserDTO userResponse = new UserDTO(newUser.getPoid(), newUser.getName(), newUser.getEmail());
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
    }
}
