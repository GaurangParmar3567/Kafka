package com.example.demo.Kafka.Comsumer;

import com.example.demo.Entities.KafkaMessages;
import com.example.demo.Repository.KafkaRepo;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;
import org.springframework.kafka.support.KafkaHeaders;

@Service
public class kafkaComsumer {

    @Autowired
    public KafkaRepo kafkaRepo;

    @Value("${kafka.topic1.name}")
    public String topicName;

    @Value("${kafka.topic2.name}")
    public String topicNameProd;

    @KafkaListener(topics = "${kafka.topic1.name}", groupId = "my-group")
    public void consume(ConsumerRecord<String, String> record) {
        String key = record.key();
        String message = record.value();

        KafkaMessages data = new KafkaMessages();
        data.setMessage(message);
        data.setTopic(topicName);
        data.setMsgkey(key);
        kafkaRepo.save(data);
        System.out.println("Received: " + message + " with key: " + key);
    }

    @KafkaListener(topics = "${kafka.topic2.name}", groupId = "my-group")
    public void consumeProd(ConsumerRecord<String, String> record) {
        String key = record.key();
        String message = record.value();

        KafkaMessages data = new KafkaMessages();
        data.setMessage(message);
        data.setTopic(topicNameProd);
        data.setMsgkey(key);
        kafkaRepo.save(data);
        System.out.println("Received: " + message + " with key: " + key);
    }
}
