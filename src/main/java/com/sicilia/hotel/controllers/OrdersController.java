package com.sicilia.hotel.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.sicilia.hotel.model.Orders;
import com.sicilia.hotel.repositories.OrdersRepo;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class OrdersController {
    @Autowired
    OrdersRepo ordersRepo;

    @GetMapping("/orders")
    public List<Orders> allOrders() {
        return ordersRepo.findAll();
    }

    @GetMapping("/order/{id}")
    public Optional<Orders> oneOrder(@PathVariable String id) {
        return ordersRepo.findById(id);
    }

    @PostMapping("/orders")
    public void postOrder(@RequestBody Orders order) {
        ordersRepo.save(order);
    }

    @PutMapping("/order/{id}")
    public void putMethodName(@PathVariable String id, @RequestBody Orders order) {
        Orders orderData = ordersRepo.findById(id).orElse(null);

        if (orderData != null) {
            orderData.setFoodImage(order.getFoodImage());
            orderData.setFoodName(order.getFoodName());
            orderData.setPrice(order.getPrice());
            orderData.setDescription(order.getDescription());

            ordersRepo.save(orderData);
        }
    }

    @DeleteMapping("/order/{id}")
    public void deleteOrder(@PathVariable String id) {
        ordersRepo.deleteById(id);
    }

}
