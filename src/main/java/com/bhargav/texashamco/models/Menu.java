package com.bhargav.texashamco.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import org.springframework.data.annotation.Id;
import java.util.List;

@Document(collection = "Menu")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Menu {

    @Id
    private String id;
    private List<Item> items;
    private String type;
}
