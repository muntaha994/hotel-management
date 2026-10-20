package com.sicilia.hotel.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sicilia.hotel.model.PendingOrders;

public interface PendingOrdersRepo extends MongoRepository<PendingOrders, String> {
}