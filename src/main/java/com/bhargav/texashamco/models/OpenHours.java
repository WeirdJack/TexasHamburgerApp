package com.bhargav.texashamco.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import org.springframework.data.annotation.Id;

@Document(collection = "OpenHours")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OpenHours {

    @Id
    private String id;

    @CreatedDate
    private DateTime openingTime;

    @LastModifiedDate
    private DateTime closingTime;
}
