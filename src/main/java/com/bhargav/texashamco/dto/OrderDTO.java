package com.bhargav.texashamco.dto;

import com.bhargav.texashamco.models.Location;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;

@Data
@NoArgsConstructor
public class OrderDTO {

    private String Id;
    private DateTime createdDate;
}
