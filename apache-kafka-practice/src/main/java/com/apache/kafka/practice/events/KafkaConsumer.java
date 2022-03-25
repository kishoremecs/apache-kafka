package com.apache.kafka.practice.events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(containerFactory = "kafkaListenerContainerFactory", groupId = "kafka-practice", topics = {"test-topic"})
    public void consume(String message) {
        LOGGER.info(" The Received message is {}", message);
    }
}
