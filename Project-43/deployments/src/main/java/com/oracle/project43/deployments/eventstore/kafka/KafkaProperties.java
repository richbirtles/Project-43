/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oracle.project43.deployments.eventstore.kafka;

import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author RBIRTLES
 */
public class KafkaProperties {

    private static final KafkaProperties INSTANCE = new KafkaProperties();
    
    private final Properties props;
    

    private KafkaProperties() {

	props = load();

    }
  
    public static KafkaProperties getInstance() {

      return INSTANCE;

    }      
    
    private Properties load() {
                
        Properties properties = new Properties();
        try {
            properties.load(KafkaProperties.class.getResourceAsStream("/kafka.properties"));
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
        
        return properties;
        
    }
    
    public Properties getProperties() {
        return props;
    }

}
    
    