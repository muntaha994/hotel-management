package com.sicilia.hotel.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sicilia.hotel.model.PendingOrders;
import com.sicilia.hotel.repositories.PendingOrdersRepo;

@RestController
public class PendingOrdersController {
    @Autowired
    PendingOrdersRepo pendingOrdersRepo;

    @GetMapping("/pending-orders")
    public List<PendingOrders> allOrders() {
        return pendingOrdersRepo.findAll();
    }

    @GetMapping("/pending-order/{id}")
    public Optional<PendingOrders> oneOrder(@PathVariable String id) {
        return pendingOrdersRepo.findById(id);
    }

    @PostMapping("/pending-order")
    public void postOrder(@RequestBody PendingOrders order) {
        pendingOrdersRepo.save(order);
    }

    @PutMapping("/pending-order/{id}")
    public void putMethodName(@PathVariable String id, @RequestBody PendingOrders order) {
        PendingOrders orderData = pendingOrdersRepo.findById(id).orElse(null);

        if (orderData != null) {
            orderData.setFoodImage(order.getFoodImage());
            orderData.setFoodName(order.getFoodName());
            orderData.setPrice(order.getPrice());
            orderData.setDescription(order.getDescription());

            pendingOrdersRepo.save(orderData);
        }
    }

    @DeleteMapping("/pending-order/{id}")
    public void deleteOrder(@PathVariable String id) {
        pendingOrdersRepo.deleteById(id);
    }

    @GetMapping("/pending/count")
    public long getPendingCount() {
        return pendingOrdersRepo.count();
    }
}
