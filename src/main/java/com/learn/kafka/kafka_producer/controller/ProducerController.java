package com.learn.kafka.kafka_producer.controller;

import com.learn.kafka.kafka_producer.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class ProducerController {

    @Autowired
    private DataService dataService;


    @GetMapping("/produce/data")
    public ResponseEntity<String> produceData() throws Exception{
        return new ResponseEntity<>(dataService.dataGenerateAndPublish(), HttpStatus.OK);
    }
}
