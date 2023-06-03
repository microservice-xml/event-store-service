package com.example.EventStore.controller;

import com.example.EventStore.service.RabbitMQProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/test")
public class TestController {

    private RabbitMQProducer producer;

    public TestController(RabbitMQProducer producer) {
        this.producer = producer;
    }

    // http://localhost:8080/api/v1/publish?message=hello
    @GetMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message){
        producer.sendMessage(message);
        return ResponseEntity.ok("Message sent to RabbitMQ ...");
    }
}
