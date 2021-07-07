package com.bhargav.texashamco.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@NoArgsConstructor
public class OpenHoursDTO {

    private String id;
    private ZonedDateTime openingTime;
    private ZonedDateTime closingTime;
}
