package com.kafka.controller;

import com.kafka.payload.User;
import com.kafka.producer.KafkaProducer;
import com.kafka.producer.KafkaJsonProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/produce")
public class ProduceController {

    private KafkaProducer kafkaProducer;

    private KafkaJsonProducer kafkaJsonProducer;

    public ProduceController(KafkaProducer kafkaProducer, KafkaJsonProducer kafkaJsonProducer) {
        this.kafkaProducer = kafkaProducer;
        this.kafkaJsonProducer = kafkaJsonProducer;
    }

    @GetMapping("/publish")
    public ResponseEntity<String> testProducer(@RequestParam("message") String message){
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("message sent to topic");
    }

    @PostMapping("/publish")
    public ResponseEntity<String> sendJsonMessage(@RequestBody User user){
        kafkaJsonProducer.sendMessage(user);
        return ResponseEntity.ok("message sent to topic");
    }
}
