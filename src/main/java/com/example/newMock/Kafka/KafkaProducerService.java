package com.example.newMock.Kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class KafkaProducerService {
    private final Producer<String, String> kafkaProducer;

    public KafkaProducerService() {
        this.kafkaProducer = createKafkaProducer();
    }

    private Producer<String, String> createKafkaProducer() {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "192.168.0.103:9092");
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        return new KafkaProducer<>(properties);
    }

    public void sendMessage(String topic, String key, String value) {
        ProducerRecord<String, String> record = new ProducerRecord<>(topic, key, value);
        kafkaProducer.send(record);
    }

    public void close() {
        kafkaProducer.close();
    }
}
