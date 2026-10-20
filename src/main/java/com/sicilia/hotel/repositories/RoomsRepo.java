package com.sicilia.hotel.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sicilia.hotel.model.Rooms;

public interface RoomsRepo extends MongoRepository<Rooms, String> {
    List<Rooms> findByHostEmail(String email);
    List<Rooms> findByCategory(String category);
}
