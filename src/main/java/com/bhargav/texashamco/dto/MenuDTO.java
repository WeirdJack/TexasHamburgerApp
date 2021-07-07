package com.bhargav.texashamco.dto;

import com.bhargav.texashamco.models.Item;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class MenuDTO {

    private String id;
    private List<Item> items;
    private String type;
}
