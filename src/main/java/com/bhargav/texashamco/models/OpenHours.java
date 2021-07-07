package com.bhargav.texashamco.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import org.springframework.data.annotation.Id;
import java.time.ZonedDateTime;

@Document(collection = "OpenHours")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OpenHours {

    @Id
    private String id;
    private ZonedDateTime openingTime;
    private ZonedDateTime closingTime;
}
