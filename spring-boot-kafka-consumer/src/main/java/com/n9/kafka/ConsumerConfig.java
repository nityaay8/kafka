package com.n9.kafka;

import com.n9.kafka.consumer.ConsumerService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class ConsumerConfig {

    @Autowired
    private ConsumerService consumerService;

    @KafkaListener(groupId = "topic_0_group-1", topics = "topic_0")
    public void listen(ConsumerRecord<String, String> payload) {

        consumerService.processMsg("group1 - consumer1 msg ", payload);
    }

    @KafkaListener(groupId = "topic_0_group-1", topics = "topic_0")
    public void consumer2(ConsumerRecord<String, String> payload) {

        consumerService.processMsg("group1 - consumer2 msg ", payload);
    }

    @KafkaListener(groupId = "topic_0_group-2", topics = "topic_0")
    public void listenGrp2(ConsumerRecord<String, String> payload) {

        consumerService.processMsg("group2 - consumer1 msg ", payload);
    }
}
