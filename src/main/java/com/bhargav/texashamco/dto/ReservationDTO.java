package com.bhargav.texashamco.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;

import java.time.ZonedDateTime;

@Data
@NoArgsConstructor
public class ReservationDTO {

    private String id;
    private DateTime startTime;
    private DateTime endTime;
    private int numberOfPeople;
}
