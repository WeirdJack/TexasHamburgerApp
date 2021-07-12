package com.bhargav.texashamco.controller;

import com.bhargav.texashamco.dto.LocationDTO;
import com.bhargav.texashamco.models.Location;
import com.bhargav.texashamco.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locations")
public class LocationController {

    @Autowired
    LocationService locationService;

    @GetMapping(value = "/all")
    public ResponseEntity<List<LocationDTO>> getAllLocations() {

        return ResponseEntity.ok(locationService.getAllLocations());
    }

    @GetMapping(value = "page/{page_number}/page_size/{page_size}")
    public ResponseEntity<Page<Location>> getLocationsByPage(@PathVariable("page_number") int pageNumber, @PathVariable("page_size") int pageSize) {

        return ResponseEntity.ok(locationService.getLocationsByPage(pageNumber, pageSize));
    }

    @GetMapping(value = "status/{status_type}")
    public ResponseEntity<Page<Location>> getLocationsByStatus(@PathVariable("status_type") String status) {

        return ResponseEntity.ok(locationService.getLocationsByStatus(status));
    }

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addLocation(@RequestBody LocationDTO locationDTO){

        locationService.addLocation(locationDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping(value = "/update/{location_name}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateLocationByName(@PathVariable String locationName, String newLocationName){

        locationService.updateLocationByName(locationName, newLocationName);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateLocation(@RequestBody LocationDTO locationDTO){

        locationService.updateLocation(locationDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/delete", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteLocation(@RequestBody LocationDTO locationDTO){

        locationService.deleteLocation(locationDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/deleteAll")
    public ResponseEntity deleteAllLocations(){

        locationService.deleteAllLocations();
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/deleteById/{location_Id}")
    public ResponseEntity deleteLocationById(@PathVariable String locationId){

        locationService.deleteLocationById(locationId);
        return ResponseEntity.ok().build();
    }
}
