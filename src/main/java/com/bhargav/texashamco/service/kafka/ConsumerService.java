package com.bhargav.texashamco.service.kafka;

import com.bhargav.texashamco.dto.OrderDTO;
import com.bhargav.texashamco.service.OrderService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    private static final Logger logger = LogManager.getLogger(ConsumerService.class);

    @Autowired
    OrderService orderService;

    @Autowired
    public ConsumerService(OrderService orderService){
        this.orderService = orderService;
    }

    @KafkaListener(containerFactory = "orderDtoKafkaListenerContainerFactory",
            topics = "${kafka.topic.order.name}",
            groupId = "${kafka.topic.order.groupId}")
    public void consumeOrdersData(@Header(KafkaHeaders.OFFSET) long offset,
                                  @Header(KafkaHeaders.RECEIVED_PARTITION_ID) Integer partition,
                                  @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                                  OrderDTO orderDTO) {
        logger.info("Order {} consumed from partition {} at offset {}", key, partition, offset);
        orderService.placeOrder(orderDTO);
    }
}
