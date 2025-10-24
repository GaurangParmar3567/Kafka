package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.KAFKA;
import com.example.demo.Entities.KafkaMessages;
import com.example.demo.JWTAuthenticateBeforeKafka.JwtUtil;

@RestController
@RequestMapping("/auth")
public class Controller {

    @Autowired
    public com.example.demo.Kafka.Producer.kafkaProducer kafkaProducer;

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/sendMessege")
    public KafkaMessages sendKafkaMessege(@RequestBody KAFKA messege) {
        System.out.println(messege.getMessege() + " Message sent to kafka topic");
        KafkaMessages savedMgs = kafkaProducer.sendMessageTest(messege.getMessege(), messege.getKey());

        return savedMgs;
    }

    @GetMapping("/sendMessegeprod")
    public KafkaMessages sendKafkaMessegeProd(@RequestBody KAFKA messege) {
        System.out.println(messege.getMessege() + " Message sent to kafka topic Production");
        KafkaMessages savedMgs = kafkaProducer.sendMessageProd(messege.getMessege(), messege.getKey());

        return savedMgs;
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        try {
            System.out.println("Attempting to authenticate user: " + username);
            System.out.println("Password provided: " + password);
            Authentication auth = authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password));
            return jwtUtil.generateToken(username);
        } catch (AuthenticationException e) {
            throw new RuntimeException("Invalid credentials");
        }
    }
}
