package com.apache.kafka.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Controller enables a REST endpoint for publishing a kafka message.
 */

@RestController
public class KafkaProducerController {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    /**
     * Method to publish a given message to a hard coded default topic. The topic name is : test-topic.
     * @param message
     * @return
     */
    @PostMapping(path = "/publishDefault", consumes = "application/json")
    public String publishKafkaEvent(@RequestBody Map<String, Object> message) {
        StringBuilder status = new StringBuilder("");
        if(!CollectionUtils.isEmpty(message)) {
            Object messageContent = message.get("event-body");
            kafkaTemplate.send("test-topic", messageContent);
            status.append("SUCCESS");
        } else {
            status.append("FAILURE");
        }
        return status.toString();
    }

    /**
     * Method to publish a given message to a given topic as part of message.
     * @param message
     * @return
     */
    @PostMapping(path = "/publish", consumes = "application/json")
    public String publish(@RequestBody Map<String, Object> message) {
        StringBuilder status = new StringBuilder("");
        if(!CollectionUtils.isEmpty(message)) {
            Object messageContent = message.get("eventBody");
            String topicName = (String) message.get("topicName");
            kafkaTemplate.send(topicName, messageContent);
            status.append("SUCCESS");
        } else {
            status.append("FAILURE");
        }
        return status.toString();
    }



}
