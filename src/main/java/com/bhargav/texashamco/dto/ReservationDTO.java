package com.bhargav.texashamco.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@NoArgsConstructor
public class ReservationDTO {

    private String id;
    private ZonedDateTime startTime;
    private ZonedDateTime endTime;
    private int numberOfPeople;
}
