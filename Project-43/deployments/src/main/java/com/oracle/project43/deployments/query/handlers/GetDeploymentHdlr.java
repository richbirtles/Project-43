/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oracle.project43.deployments.query.handlers;

import com.oracle.project43.deployments.query.queries.GetDeploymentQry;

/**
 *
 * @author RBIRTLES
 */
public class GetDeploymentHdlr {
    
    public static GetDeploymentQry execute(String id) { 
        
        // Make database call.
        GetDeploymentQry qry = new GetDeploymentQry();
               
        qry.id = id;
        qry.name = "test";
        qry.version = "12";
        
        return qry;
        
    }
    
    
}
