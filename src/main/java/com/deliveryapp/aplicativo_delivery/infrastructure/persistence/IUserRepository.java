package com.deliveryapp.aplicativo_delivery.infrastructure.persistence;

import com.deliveryapp.aplicativo_delivery.domain.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface IUserRepository extends MongoRepository<User, String> {
    Optional<User> findByEmail(String email);
}
