/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gre.prototype.model.json;

import com.google.gson.Gson;
import com.model.dao.DummyOmniDAO;
import com.model.pojos.Node;
import java.util.List;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

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
     * Retrieves representation of an instance of
     * com.model.json.FindNodesResource
     *
     * @return an instance of java.lang.String
     */
    private String findNodes(String pTest) {
        DummyOmniDAO dao = new DummyOmniDAO();

        List<Node> nodes = dao.findNodes(pTest);

        Gson gson = new Gson();
        String json = gson.toJson(nodes);
        System.out.println("JSON: " + json);
        return json;
    }

    @POST
    @Produces("application/json")
    public String postJson(@FormParam("test") String pTest) {

        return findNodes(pTest);
    }

    @GET
    @Produces("application/json")
    public String getJson(@QueryParam("test") String pTest) {
        return findNodes(pTest);
    }
}
