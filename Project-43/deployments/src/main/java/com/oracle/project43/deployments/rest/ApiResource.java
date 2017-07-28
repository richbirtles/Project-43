/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oracle.project43.deployments.rest;

import com.oracle.project43.deployments.command.commands.DeployCmd;
import com.oracle.project43.deployments.query.queries.GetDeploymentQry;
import com.oracle.project43.deployments.service.CommandService;
import com.oracle.project43.deployments.service.QueryService;
import java.net.URI;
import java.util.UUID;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author RBIRTLES
 */
@Path("api")
public class ApiResource {

    @Context
    private UriInfo context;

    public ApiResource() {
    }


    @POST
    public Response submitDeployment(JsonObject deployment) {
        final String name = deployment.getString("name", null);
        final String version = deployment.getString("version", null);
        
        if (version == null)
            return Response.status(Response.Status.BAD_REQUEST).build();

        final String id = UUID.randomUUID().toString();
        
        CommandService.deployApplication(new DeployCmd(id, name, version));

        final URI uri = context.getRequestUriBuilder().path(ApiResource.class, "getDeployment").build(id);
        return Response.accepted().header(HttpHeaders.LOCATION, uri).build();
    }

    
    @GET
    @Path("{id}")
    public JsonObject getDeployment(@PathParam("id") String id) {
        
        System.out.println("Got here");
            
        final GetDeploymentQry qry = QueryService.getDeployment(id);

        if (qry == null) {
            throw new NotFoundException();
        }
        
        return Json.createObjectBuilder()
                .add("id", qry.id)
                .add("version", qry.version)
                .add("name", qry.name)                
                .build();
    }



}
