package com.example.demo.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "kafka_messages")
@Data
public class KafkaMessages {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String message;
    String topic;
    String msgkey;

    public KafkaMessages() {
    }

    public KafkaMessages(int id, String message, String topic, String msgkey) {
        this.id = id;
        this.message = message;
        this.topic = topic;
        this.msgkey = msgkey;
    }

    public int getId() {
        return id;
    }

    public String getMsgkey() {
        return msgkey;
    }

    public void setMsgkey(String msgkey) {
        this.msgkey = msgkey;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

}

