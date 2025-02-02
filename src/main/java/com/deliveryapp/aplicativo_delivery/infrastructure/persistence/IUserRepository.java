package com.deliveryapp.aplicativo_delivery.infrastructure.persistence;

import com.deliveryapp.aplicativo_delivery.domain.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IUserRepository extends MongoRepository<User, String> {
}
