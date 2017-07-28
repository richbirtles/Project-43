/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oracle.project43;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import com.oracle.project43.deployments.rest.*;
/**
 *
 * @author RBIRTLES
 */


@ApplicationPath("1.0")
public class WSConfiguration extends Application {
    
    public WSConfiguration() {
        
        System.out.println("Services Loading...");

    }
    
    public Set<Class<?>> getClasses() {
        
        Set<Class<?>> classes = new HashSet<Class<?>>();

        // Register root resources.
        
        classes.add(ApiResource.class);
       

        return classes;
    }
    
    
    
}
