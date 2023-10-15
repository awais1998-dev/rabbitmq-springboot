package com.tech.springbootrabbitmq.controller;

import com.tech.springbootrabbitmq.dto.User;
import com.tech.springbootrabbitmq.producer.RabbitMQJsonProducer;
import com.tech.springbootrabbitmq.producer.RabbitMQProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class MessageController {

    @Autowired
    private RabbitMQProducer producer;

    @Autowired
    private RabbitMQJsonProducer jsonProducer;

    @GetMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message){
        producer.sendMessage(message);
        return ResponseEntity.ok("Message sent successfully");
    }

    @PostMapping("/publish")
    public ResponseEntity<String> sendJsonMessage(@RequestBody User user){
        jsonProducer.sendJsonMessage(user);
        return ResponseEntity.ok("Message sent successfully...");
    }

}
