///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//package org.gre.prototype.restful.json;
//
//import com.google.gson.Gson;
//import javax.ws.rs.core.Context;
//import javax.ws.rs.core.UriInfo;
//import javax.ws.rs.FormParam;
//import javax.ws.rs.Path;
//import javax.ws.rs.POST;
//import javax.ws.rs.Produces;
//import org.gre.prototype.model.dao.fakes.OmniDAOFake;
//import org.gre.prototype.model.pojos.Node;
//
///**
// * REST Web Service
// *
// * @author ppadilla
// */
//@Path("getNode")
//public class GetNodeResource {
//
//    @Context
//    private UriInfo context;
//
//    /**
//     * Creates a new instance of GetNodeResource
//     */
//    public GetNodeResource() {
//    }
//
//    /**
//     * Retrieves representation of an instance of
//     * org.gre.prototype.restful.json.GetNodeResource
//     *
//     * @return an instance of java.lang.String
//     */
//    @POST
//    @Produces("application/json")
//    public String postJson(@FormParam("nodeId") String nodeId) {
//
//        OmniDAOFake dao = new OmniDAOFake();
//
//        int id = Integer.parseInt(nodeId);
//        Node result = dao.getNode(id);
//
//        Gson gson = new Gson();
//
//        return gson.toJson(result);
//    }
//}
