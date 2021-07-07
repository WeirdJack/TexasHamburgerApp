package com.bhargav.texashamco.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddressDTO {

    private String id;
    private String address_line_1;
    private String address_line_2;
    private String city;
    private String state;
    private String country;
}
