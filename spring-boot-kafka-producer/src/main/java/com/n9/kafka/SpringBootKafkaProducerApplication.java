package com.n9.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class SpringBootKafkaProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootKafkaProducerApplication.class, args);
    }

}
