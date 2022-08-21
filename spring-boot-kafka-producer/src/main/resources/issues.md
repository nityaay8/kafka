## issue
Caused by: io.confluent.kafka.schemaregistry.client.rest.exceptions.RestClientException: Unauthorized; error code: 401
at io.confluent.kafka.schemaregistry.client.rest.RestService.sendHttpRequest(RestService.java:191)
at io.confluent.kafka.schemaregistry.client.rest.RestService.httpRequest(RestService.java:218)
at io.confluent.kafka.schemaregistry.client.rest.RestService.registerSchema(RestService.java:307)
at io.confluent.kafka.schemaregistry.client.rest.RestService.registerSchema(RestService.java:299)
at io.confluent.kafka.schemaregistry.client.rest.RestService.registerSchema(RestService.java:294)
at io.confluent.kafka.schemaregistry.client.CachedSchemaRegistryClient.registerAndGetId(CachedSchemaRegistryClient.java:61)
at io.confluent.kafka.schemaregistry.client.CachedSchemaRegistryClient.register(CachedSchemaRegistryClient.java:100)
at io.confluent.kafka.serializers.AbstractKafkaAvroSerializer.serializeImpl(AbstractKafkaAvroSerializer.java:79)

## to fix above issue
## upgarde 5.3.0
 <dependency>
            <groupId>io.confluent</groupId>
            <artifactId>kafka-avro-serializer</artifactId>
<!--            <version>4.0.0</version>-->
            <version>5.3.0</version>
        </dependency>