/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oracle.project43.deployments.service;

import com.oracle.project43.deployments.query.handlers.GetDeploymentHdlr;
import com.oracle.project43.deployments.query.queries.GetDeploymentQry;

/**
 *
 * @author RBIRTLES
 */
public class QueryService {
 
    public static GetDeploymentQry getDeployment(String id) {
        
        GetDeploymentQry qry = GetDeploymentHdlr.execute(id);
        
        return qry;
        
    }
    
}
