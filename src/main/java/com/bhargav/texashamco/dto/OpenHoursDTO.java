package com.bhargav.texashamco.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;

import java.time.ZonedDateTime;

@Data
@NoArgsConstructor
public class OpenHoursDTO {

    private String id;
    private DateTime openingTime;
    private DateTime closingTime;
}
