package com.example.demo.Kafka.Producer;

import com.example.demo.Entities.KafkaMessages;
import com.example.demo.Repository.KafkaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class kafkaProducer {

    @Value("${kafka.topic1.name}")
    public String topicName;

    @Value("${kafka.topic2.name}")
    public String topicNameProd;

    @Autowired
    public KafkaRepo kafkaRepo;

    private final KafkaTemplate<String, String> kafkaTemplate;

    public kafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public KafkaMessages sendMessageTest(String message, String key) {
         kafkaTemplate.send(topicName, key, message);
        System.out.println("Sent: " + message);

        KafkaMessages receiceMsg = kafkaRepo.getLastMessage(key);
        if (receiceMsg != null) {
            return receiceMsg;
        }
        return new KafkaMessages(0, "No Message", "No Topic", "No Key");

    }

    public KafkaMessages sendMessageProd(String message, String key) {
        kafkaTemplate.send(topicNameProd, key, message);
        System.out.println("Sent: " + message);

        KafkaMessages receiceMsg = kafkaRepo.getLastMessage(key);
        if (receiceMsg != null) {
            return receiceMsg;
        }
        return new KafkaMessages(0, "No Message", "No Topic", "No Key");
    }
}
