package com.sicilia.hotel.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class User {
    @Id
    private String id;

    @Indexed(unique = true)
    private String email;
    private String name;
    private String image;
    private String role;
    private String status;
    private Long timestamp;
}
