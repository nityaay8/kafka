package com.n9.kafka;

import com.n9.kafka.consumer.ConsumerService;
import com.n9.schema.Employee;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class ConsumerConfig {

    private static final String kafkaTopic = "topic_3";

    @Autowired
    private ConsumerService consumerService;

    @KafkaListener(groupId = "topic_0_group-1", topics = kafkaTopic)
    public void listen(ConsumerRecord<String, Employee> payload) {

        consumerService.processMsg("group1 - consumer1 msg ", payload);
    }

    @KafkaListener(groupId = "topic_0_group-1", topics = kafkaTopic)
    public void consumer2(ConsumerRecord<String, Employee> payload) {

        consumerService.processMsg("group1 - consumer2 msg ", payload);
    }

    @KafkaListener(groupId = "topic_0_group-2", topics = kafkaTopic)
    public void listenGrp2(ConsumerRecord<String, Employee> payload) {

        consumerService.processMsg("group2 - consumer1 msg ", payload);
    }
}
