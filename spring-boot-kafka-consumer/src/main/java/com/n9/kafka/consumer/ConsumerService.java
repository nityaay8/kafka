package com.n9.kafka.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.n9.kafka.model.ConsumerInfo;
import com.n9.kafka.model.Employee;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    private ObjectMapper mapper = new ObjectMapper();

    public void processMsg(String consumer, ConsumerRecord<String, Employee> payload) {

        try {
            ConsumerInfo consumerInfo = new ConsumerInfo();
            consumerInfo.setKey(payload.key());
            consumerInfo.setValue(payload.value());
            consumerInfo.setPartition(payload.partition());
            consumerInfo.setTopic(payload.topic());
            consumerInfo.setOffset(payload.offset());

            System.out.println("received value  =" + payload.value());


            String jsonStr = mapper.writeValueAsString(consumerInfo);

            System.out.println(consumer + " = " + jsonStr);
            System.out.println(" ");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
