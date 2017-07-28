/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oracle.project43.deployments.command.commands;

/**
 *
 * @author RBIRTLES
 */
public class DeployCmd {
    
    public DeployCmd(String id, String name, String version) {
        this.id = id;
        this.name = name;
        this.version = version;
        
    }
    
    public String id;
    public String name;
    public String version;
    
}
