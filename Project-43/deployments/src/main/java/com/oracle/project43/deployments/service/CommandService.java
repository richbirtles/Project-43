/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oracle.project43.deployments.service;

import com.oracle.project43.deployments.command.commands.DeployCmd;
import com.oracle.project43.deployments.command.handlers.DeployHdlr;

/**
 *
 * @author RBIRTLES
 */
public class CommandService {
 
    public static void deployApplication(DeployCmd cmd) {
        
        DeployHdlr.execute(cmd);
            
    }
    
}
