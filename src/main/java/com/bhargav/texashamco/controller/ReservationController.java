package com.bhargav.texashamco.controller;

import com.bhargav.texashamco.dto.ReservationDTO;
import com.bhargav.texashamco.models.OpenHours;
import com.bhargav.texashamco.models.Reservation;
import com.bhargav.texashamco.service.OpenHoursService;
import com.bhargav.texashamco.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    @GetMapping(value = "/all")
    public ResponseEntity<List<ReservationDTO>> getAllReservations() {

        return ResponseEntity.ok(reservationService.getAllReservations());
    }

    @GetMapping(value = "page/{page_number}/page_size/{page_size}")
    public ResponseEntity<Page<Reservation>> getReservationsByPage(@PathVariable("page_number") int pageNumber, @PathVariable("page_size") int pageSize) {

        return ResponseEntity.ok(reservationService.getReservationsByPage(pageNumber, pageSize));
    }

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addReservation(@RequestBody ReservationDTO reservationDTO){

        reservationService.addReservation(reservationDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateReservation(@RequestBody ReservationDTO reservationDTO){

        reservationService.updateReservation(reservationDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/delete", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteReservation(@RequestBody ReservationDTO reservationDTO){

        reservationService.deleteReservation(reservationDTO);
        return ResponseEntity.ok().build();
    }
}
