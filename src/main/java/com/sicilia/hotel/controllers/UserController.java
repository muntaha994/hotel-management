package com.sicilia.hotel.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sicilia.hotel.model.User;
import com.sicilia.hotel.repositories.UserRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @PutMapping("/user")
    public User saveUser(@RequestBody User incoming) {

        if (incoming.getEmail() == null) {
            return null;
        }

        User existing = userRepo.findByEmail(incoming.getEmail());

        // --------------------------------------------------
        // CASE 1 — name/image provided → update only these two fields
        // --------------------------------------------------
        if (incoming.getName() != null || incoming.getImage() != null) {

            if (existing == null) {
                // No user exists → create a new one
                incoming.setTimestamp(System.currentTimeMillis());
                return userRepo.save(incoming);
            }

            // Update fields like Express
            if (incoming.getName() != null)
                existing.setName(incoming.getName());

            if (incoming.getImage() != null)
                existing.setImage(incoming.getImage());

            return userRepo.save(existing);
        }

        // --------------------------------------------------
        // CASE 2 — no name/image passed → return existing user if found
        // --------------------------------------------------
        if (existing != null) {
            return existing; // same as ExpressJS res.send(isExists)
        }

        // --------------------------------------------------
        // CASE 3 — no existing user and no name/image → create new user
        // --------------------------------------------------
        incoming.setTimestamp(System.currentTimeMillis());
        return userRepo.save(incoming);
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @GetMapping("/user/{email}")
    public User getMethodName(@PathVariable String email) {
        return userRepo.findByEmail(email);
    }

    @PatchMapping("/user/role/{id}")
    public User makeAdmin(@PathVariable String id, @RequestBody User roleUpdate) {
        User user = userRepo.findById(id).orElse(null);

        if (roleUpdate.getRole() != null) {
            user.setRole(roleUpdate.getRole());
        }
        return userRepo.save(user);
    }

    @GetMapping("/users/count")
    public long getUserCount() {
        return userRepo.count();
    }
}
