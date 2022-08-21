package com.n9.kafka.producer;

import com.n9.kafka.model.EmployeeReq;
import com.n9.kafka.model.ProducedInfo;
import com.n9.schema.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

@Service
public class ProducerService {

    @Autowired
    private KafkaTemplate<String, Employee> kafkaTemplate;


    String kafkaTopic1 = "topic_3";


    public ProducedInfo send(EmployeeReq message) throws Exception {

        ProducedInfo producedInfo = new ProducedInfo();

        Employee employee = Employee.newBuilder().setId(message.getId()).setFirstName(message.getName()).setLastName(message.getName()).build();

        ListenableFuture<SendResult<String, Employee>> resultFuture = kafkaTemplate.send(kafkaTopic1, employee);

        SendResult<String, Employee> result = resultFuture.get();

        producedInfo.setOffset(result.getRecordMetadata().offset());

        producedInfo.setTopicName(result.getProducerRecord().topic());

        producedInfo.setTopicPartition(result.getRecordMetadata().partition());

        producedInfo.setValue(result.getProducerRecord().value().toString());


        return producedInfo;
    }

}
