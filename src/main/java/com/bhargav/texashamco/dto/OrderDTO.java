package com.bhargav.texashamco.dto;

import com.bhargav.texashamco.models.Location;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderDTO {

    private String Id;
    private Location location;
}
