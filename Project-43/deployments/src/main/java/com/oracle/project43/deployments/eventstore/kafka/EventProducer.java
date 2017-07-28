/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oracle.project43.deployments.eventstore.kafka;

import java.util.Properties;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

/**
 *
 * @author RBIRTLES
 */
public class EventProducer {
    
    
    private final static String TOPIC = "deployments";   

    public static void publish(String event) {

        final Producer<String, String> producer = createProducer();

        try {
        
            final ProducerRecord<String, String> record = new ProducerRecord<>(TOPIC, event);

            System.out.println("publishing = " + record);
            producer.send(record);

      } finally {
          producer.flush();
          producer.close();
      
     }
    }

    
    private static Producer<String, String> createProducer() {
        
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ProducerConfig.CLIENT_ID_CONFIG, "DeploymentProducer");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
    
        return new KafkaProducer<>(props);

    }
    
}
