package com.bhargav.texashamco.dto;

import com.bhargav.texashamco.models.Address;
import com.bhargav.texashamco.models.Menu;
import com.bhargav.texashamco.models.OpenHours;
import com.bhargav.texashamco.models.Reservation;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class LocationDTO {

    private String id;
    private String name;
    private Address address;
    private List<Reservation> reservations;
    private OpenHours openHours;
    private Menu menu;
    private String currentStatus;
}
