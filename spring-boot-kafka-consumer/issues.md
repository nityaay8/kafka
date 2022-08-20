## issue
	at org.springframework.kafka.listener.KafkaMessageListenerContainer$ListenerConsumer.run(KafkaMessageListenerContainer.java:1255) ~[spring-kafka-2.8.8.jar:2.8.8]
	... 4 common frames omitted
Caused by: java.lang.IllegalStateException: No type information in headers and no default type provided
at org.springframework.util.Assert.state(Assert.java:76) ~[spring-core-5.3.22.jar:5.3.22]
at org.springframework.kafka.support.serializer.JsonDeserializer.deserialize(JsonDeserializer.java:583) ~[spring-kafka-2.8.8.jar:2.8.8]
at org.apache.kafka.clients.consumer.internals.Fetcher.parseRecord(Fetcher.java:1439) ~[kafka-clients-3.1.1.jar:na]
... 16 common frames omitted

## to fix the above the issue. [specify default type]
spring.kafka.consumer.properties.spring.json.value.default.type=com.n9.kafka.model.Employee