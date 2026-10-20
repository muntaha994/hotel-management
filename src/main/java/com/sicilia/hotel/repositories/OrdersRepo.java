package com.sicilia.hotel.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sicilia.hotel.model.Orders;

public interface OrdersRepo extends MongoRepository<Orders, String> {

}
