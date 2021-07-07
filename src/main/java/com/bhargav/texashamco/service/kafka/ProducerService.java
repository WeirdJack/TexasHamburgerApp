package com.bhargav.texashamco.service.kafka;

import com.bhargav.texashamco.dto.OrderDTO;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.UUID;

@Service
public class ProducerService {

    private final KafkaTemplate<String, OrderDTO> orderDtoKafkaTemplate;
    private static final Logger logger = LogManager.getLogger(ProducerService.class);

    @Value("${kafka.topic.order.name}")
    private String JSON_TOPIC;

    public ProducerService(KafkaTemplate<String, OrderDTO> kafkaTemplate) {
        this.orderDtoKafkaTemplate = kafkaTemplate;
    }

    public boolean sendOrder(OrderDTO orderDTO) {
        logger.info(String.format("Producing Order: %s", orderDTO));

        orderDtoKafkaTemplate.executeInTransaction(transaction -> {
            ListenableFuture<SendResult<String, OrderDTO>> future = transaction.send(JSON_TOPIC, UUID.randomUUID().toString(), orderDTO);
            future.addCallback(new ListenableFutureCallback<SendResult<String, OrderDTO>>() {
                @Override
                public void onFailure(Throwable throwable) {
                    logger.info("Unable to process order {} due to ", orderDTO, throwable.getMessage());
                }

                @Override
                public void onSuccess(SendResult<String, OrderDTO> result) {
                    RecordMetadata sentOrder = result.getRecordMetadata();
                    logger.info(String.format("Produced order {} at offset {}", sentOrder.offset(), sentOrder.topic()));
                }
            });
            return true;
        });
        return true;
    }
}
