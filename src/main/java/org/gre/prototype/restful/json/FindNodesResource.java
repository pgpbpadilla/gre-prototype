/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gre.prototype.restful.json;

import com.google.gson.Gson;
import org.gre.prototype.model.dao.fakes.OmniDAOFake;
import org.gre.prototype.model.pojos.Node;
import java.util.List;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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

    @POST
    @Produces("application/json")
    public String postJson(@FormParam("searchText") String searchText) {

        OmniDAOFake daoFake = new OmniDAOFake();

        List<Node> nodes = daoFake.findNodes(searchText);

        Gson gson = new Gson();
        String json = gson.toJson(nodes);

        return json;
    }
}
