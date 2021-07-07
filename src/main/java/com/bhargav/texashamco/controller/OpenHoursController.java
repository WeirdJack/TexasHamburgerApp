package com.bhargav.texashamco.controller;

import com.bhargav.texashamco.dto.OpenHoursDTO;
import com.bhargav.texashamco.models.OpenHours;
import com.bhargav.texashamco.service.OpenHoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/openhours")
public class OpenHoursController {

    @Autowired
    OpenHoursService openHoursService;

    @GetMapping(value = "/all")
    public ResponseEntity<List<OpenHoursDTO>> getAllLocations() {

        return ResponseEntity.ok(openHoursService.getAllOpenHours());
    }

    @GetMapping(value = "page/{page_number}/page_size/{page_size}")
    public ResponseEntity<Page<OpenHours>> getOpenHoursByPage(@PathVariable("page_number") int pageNumber, @PathVariable("page_size") int pageSize) {

        return ResponseEntity.ok(openHoursService.getOpenHoursByPage(pageNumber, pageSize));
    }

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addMenu(@RequestBody OpenHoursDTO openHoursDTO){

        openHoursService.addOpenHours(openHoursDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateMenu(@RequestBody OpenHoursDTO openHoursDTO){

        openHoursService.updateOpenHours(openHoursDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/delete", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteMenu(@RequestBody OpenHoursDTO openHoursDTO){

        openHoursService.deleteOpenHours(openHoursDTO);
        return ResponseEntity.ok().build();
    }
}
