package com.sicilia.hotel.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sicilia.hotel.model.User;

public interface UserRepo extends MongoRepository<User, String> {
    User findByEmail(String email);
}