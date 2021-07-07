package com.bhargav.texashamco.controller;

import com.bhargav.texashamco.dto.OrderDTO;
import com.bhargav.texashamco.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping(value = "/createOrder", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addLocation(@RequestBody OrderDTO orderDTO){

        orderService.placeOrder(orderDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
