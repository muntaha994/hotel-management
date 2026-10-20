package com.sicilia.hotel.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.sicilia.hotel.model.Rooms;
import com.sicilia.hotel.repositories.RoomsRepo;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class RoomController {
    @Autowired
    RoomsRepo roomsRepo;

    // @GetMapping("/rooms")
    // public List<Rooms> allRooms() {
    // return roomsRepo.findAll();
    // }

    @GetMapping("/rooms")
    public List<Rooms> getRooms(
        @RequestParam(required = false) String category) {
        if (category != null && !category.isEmpty()) {
            return roomsRepo.findByCategory(category);
        }
        return roomsRepo.findAll();
    }

    @PostMapping("/rooms")
    public void postRoom(@RequestBody Rooms room) {
        roomsRepo.save(room);
    }

    @GetMapping("/room/{id}")
    public Optional<Rooms> getOneRoom(@PathVariable String id) {
        return roomsRepo.findById(id);
    }

    @GetMapping("/singleroom/{id}")
    public Rooms getSingleRoom(@PathVariable String id) {
        return roomsRepo.findById(id).orElse(null);
    }

    @PutMapping("/room/{id}")
    public void updateOneRoom(@PathVariable String id, @RequestBody Rooms room) {
        Rooms roomData = roomsRepo.findById(id).orElse(null);

        if (roomData != null) {
            roomData.setRoomNumber(room.getRoomNumber());
            roomData.setTitle(room.getTitle());
            roomData.setCategory(room.getCategory());
            roomData.setImage(room.getImage());
            roomData.setStartDate(room.getStartDate());
            roomData.setEndDate(room.getEndDate());
            roomData.setPrice(room.getPrice());
            roomData.setTotal_guest(room.getTotal_guest());
            roomData.setBathrooms(room.getBathrooms());
            roomData.setBedrooms(room.getBedrooms());
            roomData.setDescription(room.getDescription());

            roomsRepo.save(roomData);

        }
    }

    @DeleteMapping("/room/{id}")
    public void deleteRoom(@PathVariable String id) {
        roomsRepo.deleteById(id);
    }

    @GetMapping("/my-listings/{email}")
    public List<Rooms> getMyListings(@PathVariable String email) {
        return roomsRepo.findByHostEmail(email);
    }

    @GetMapping("/rooms/count")
    public long getRoomsCount() {
        return roomsRepo.count();
    }

}
