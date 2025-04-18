package com.learn.kafka.kafka_producer.service.impl;

import com.learn.kafka.kafka_producer.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class DataServiceImpl implements DataService {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    @Override
    public String dataGenerateAndPublish() throws Exception {
        int counter = 100;
        while(counter > 0){
            counter--;
            kafkaTemplate.send("products", generateData());
        }
        return "Data generated and published successfully";
    }

    private String generateData() {
        return "Product"+ Math.random();
    }
}
