package com.bhargav.texashamco.controller;

import com.bhargav.texashamco.dto.OrderDTO;
import com.bhargav.texashamco.service.kafka.ProducerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

    private final ProducerService producerService;

    public KafkaController(ProducerService producerService) {
        this.producerService = producerService;
    }

    @PostMapping("/publish")
    public void messageToTopic(@RequestParam("order")OrderDTO orderDTO){

        producerService.sendOrder(orderDTO);
    }
}
