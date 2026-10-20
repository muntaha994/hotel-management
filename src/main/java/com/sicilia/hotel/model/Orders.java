package com.sicilia.hotel.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Orders {
    @Id
    private String id;
    private String roomNumber;
    private String foodImage;
    private String foodName;
    private String guestEmail;
    private String guestImage;
    private String guestName;
    private Integer price;
    private String description;
}
