package com.bhargav.texashamco.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Address")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    private String id;
    private String address_line_1;
    private String address_line_2;
    private String city;
    private String state;
    private String country;
}
