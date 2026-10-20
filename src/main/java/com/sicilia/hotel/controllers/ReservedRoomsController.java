package com.sicilia.hotel.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.sicilia.hotel.model.ReservedRooms;
import com.sicilia.hotel.repositories.ReservedRoomsRepo;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class ReservedRoomsController {
    @Autowired
    ReservedRoomsRepo reservedRoomsRepo;

    @GetMapping("/reserved-rooms")
    public List<ReservedRooms> allReservedRooms() {
        return reservedRoomsRepo.findAll();
    }

    @PostMapping("/reserved-rooms")
    public void postReserveRoom(@RequestBody ReservedRooms room) {
        reservedRoomsRepo.save(room);
    }

    @GetMapping("/reserved-room/{id}")
    public Optional<ReservedRooms> getOneReservedRoom(@PathVariable String id) {
        return reservedRoomsRepo.findById(id);
    }

    @DeleteMapping("/reserved-room/{id}")
    public void deleteReserveRoom(@PathVariable String id) {
        reservedRoomsRepo.deleteById(id);
    }

    // get one room for guest
    @GetMapping("/my-bookings/{email}")
    public List<ReservedRooms> getReservedRooms(@PathVariable String email) {
        return reservedRoomsRepo.findByGuestEmail(email);
    }
}
