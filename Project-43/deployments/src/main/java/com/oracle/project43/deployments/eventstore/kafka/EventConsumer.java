/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oracle.project43.deployments.eventstore.kafka;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

/**
 *
 * @author RBIRTLES
 */
public class EventConsumer {
    
    private final static List<String> TOPICS =  Arrays.asList("deployments");

    
    public void consume() {

        Consumer consumer = createConsumer();
        consumer.subscribe(TOPICS);

        while (true) {
            
            ConsumerRecords<String, String> records = consumer.poll(100);
            
            for (ConsumerRecord<String, String> record : records) {
                
                System.out.printf("Received: offset = %d, key = %s, value = %s", record.offset(), record.key(), record.value());
            }
        }
            
    }
     
    private static Consumer<String, String> createConsumer() {
        
        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ConsumerConfig.CLIENT_ID_CONFIG, "DeploymentConsumer");
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "DeploymentConsumerGroup");      
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "true");
        props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "1000");
        props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "30000");        
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
    
        return new KafkaConsumer<>(props);

    }
     
    
}
