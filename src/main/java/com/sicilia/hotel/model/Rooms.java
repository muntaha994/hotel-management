package com.sicilia.hotel.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document("rooms")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Rooms {
    @Id
    private String id;
    private String location;
    private String title;
    private String category;
    private String image;
    @JsonProperty("from")
    private String startDate;
    @JsonProperty("to")
    private String endDate;
    private Integer price;
    private Integer total_guest;
    private Integer bedrooms;
    private Integer bathrooms;
    private String description;
    private String roomNumber;

    public Host host;

    public static class Host {
        public String name;
        public String image;
        public String email;
    }
}
