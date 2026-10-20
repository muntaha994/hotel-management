package com.sicilia.hotel.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sicilia.hotel.model.ReservedRooms;

public interface ReservedRoomsRepo extends MongoRepository<ReservedRooms, String> {
    List<ReservedRooms> findByGuestEmail(String guestEmail);
}
