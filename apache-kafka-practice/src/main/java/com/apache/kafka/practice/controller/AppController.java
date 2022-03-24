package com.apache.kafka.practice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @GetMapping(path = "/")
    public String root() {
        return "Hello Apache Kafka!!!";
    }
}
