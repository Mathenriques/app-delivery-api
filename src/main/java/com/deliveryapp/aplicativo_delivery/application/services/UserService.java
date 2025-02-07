package com.deliveryapp.aplicativo_delivery.application.services;

import com.deliveryapp.aplicativo_delivery.application.exceptions.FailedCreateUserException;
import com.deliveryapp.aplicativo_delivery.domain.models.User;
import com.deliveryapp.aplicativo_delivery.infrastructure.persistence.IUserRepository;
import com.deliveryapp.aplicativo_delivery.presentation.dtos.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private IUserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(user -> {
                    return new UserDTO(user.getPoid(), user.getName(), user.getEmail());
                })
                .collect(Collectors.toList());
    }

    public UserDTO saveUser(User user) throws Exception {
        User savedUser;
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        try {
            savedUser = userRepository.save(user);
        } catch (Exception e) {
            throw new FailedCreateUserException();
        }
        return new UserDTO(savedUser.getPoid(), savedUser.getName(), savedUser.getEmail());
    }

//    public Optional<User> buscarUsuarioPorId(String id) {
//        return userRepository.findById(id);
//    }
//
//
//    public void deletarUsuario(String id) {
//        userRepository.deleteById(id);
//    }
//
//    public User atualizarUsuario(String id, User usuarioAtualizado) {
//        usuarioAtualizado.setId(id);
//        return userRepository.save(usuarioAtualizado);
//    }
}