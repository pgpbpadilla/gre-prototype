/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.json;

import com.google.gson.Gson;
import com.model.dao.DummyOmniDAO;
import com.model.pojos.Link;
import com.model.pojos.Node;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;

/**
 * REST Web Service
 *
 * @author ppadilla
 */
@Path("findNodes")
public class FindNodesResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of FindNodesResource
     */
    public FindNodesResource() {
    }

    /**
     * Retrieves representation of an instance of com.model.json.FindNodesResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getJson() {
        
        DummyOmniDAO dao= new DummyOmniDAO();
        
        List<Node> nodes= dao.getAllNodes();
//        Link test= new Link(0, "test", new Node(), new Node());
        
        Gson gson= new Gson();
        String json= gson.toJson(nodes);
        System.out.println("JSON: " + json);
                
        return json;
    }

    /**
     * PUT method for updating or creating an instance of FindNodesResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
}
