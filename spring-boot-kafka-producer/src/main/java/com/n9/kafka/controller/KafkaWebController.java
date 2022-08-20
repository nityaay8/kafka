package com.n9.kafka.controller;

import com.n9.kafka.model.Employee;
import com.n9.kafka.model.ProducedInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.support.SendResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.n9.kafka.producer.ProducerService;

@RestController
@RequestMapping("/kafka")
public class KafkaWebController {

    @Autowired
    private ProducerService producerService;

    @PostMapping("send")
    public ResponseEntity sendMsg(@RequestBody String body) {
        ProducedInfo producedInfo  = null;
        try {
            System.out.println("req = " + body);
            producedInfo = producerService.send(body);
            System.out.println("message sent = " + producedInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok(producedInfo);

    }



}
