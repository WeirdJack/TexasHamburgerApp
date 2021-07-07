package com.bhargav.texashamco.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import org.springframework.data.annotation.Id;

import java.util.List;

@Document(collection = "Location")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Location {

    @Id
    private String id;
    private String name;
    private Address address;
    private List<Reservation> reservations;
    private OpenHours openHours;
    private Menu menu;
    private String currentStatus;
}
