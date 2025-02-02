package com.deliveryapp.aplicativo_delivery.application.services;

import com.deliveryapp.aplicativo_delivery.domain.models.User;
import com.deliveryapp.aplicativo_delivery.infrastructure.persistence.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private IUserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
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