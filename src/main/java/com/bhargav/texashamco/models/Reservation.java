package com.bhargav.texashamco.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.ZonedDateTime;

@Document(collection = "Reservation")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {

    @Id
    private String id;
    private ZonedDateTime startTime;
    private ZonedDateTime endTime;
    private int numberOfPeople;
}
