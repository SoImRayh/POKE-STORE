package dev.rayh.cardstore.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.stereotype.Component;

@Component
public class KafkaBeans {
@Bean
    public NewTopic topic (){
    System.out.println("tentando configurar issso no inicio");
        return TopicBuilder.name("email").partitions(10).replicas(1).build();
    }
}
