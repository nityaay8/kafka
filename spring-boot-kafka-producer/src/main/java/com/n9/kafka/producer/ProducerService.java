package com.n9.kafka.producer;

import com.n9.kafka.model.Employee;
import com.n9.kafka.model.ProducedInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

@Service
public class ProducerService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;



    String kafkaTopic1 = "topic_0";

    String kafkaTopic2 = "topic_2";

    public ProducedInfo send(String message) throws Exception {

        ProducedInfo producedInfo = new ProducedInfo();

        ListenableFuture<SendResult<String, String>> resultFuture = kafkaTemplate.send(kafkaTopic1, message);

        SendResult<String, String> result = resultFuture.get();

        producedInfo.setOffset(result.getRecordMetadata().offset());

        producedInfo.setTopicName(result.getProducerRecord().topic());

        producedInfo.setTopicPartition(result.getRecordMetadata().partition());

        producedInfo.setValue(result.getProducerRecord().value());


        return producedInfo;
    }



}
