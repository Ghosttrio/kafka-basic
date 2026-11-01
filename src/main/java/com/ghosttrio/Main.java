package com.ghosttrio;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.*;

import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "io.confluent.kafka.serializers.KafkaAvroSerializer");
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "io.confluent.kafka.serializers.KafkaAvroSerializer");
        properties.put("schema.registry.url", "http://localhost:8081");

        String topic = "customerContacts";

        Producer<String, Customer> producer = new KafkaProducer<>(properties);

        while (true) {

        }

//        ProducerRecord<String, String> record = new ProducerRecord<>("test", "test2", "test3");
//        try {
//            producer.send(record, new DemoProducerCallback());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    private static class DemoProducerCallback implements Callback {

        @Override
        public void onCompletion(RecordMetadata recordMetadata, Exception e) {
            if (e != null) {
                e.printStackTrace();
            }
        }
    }
}