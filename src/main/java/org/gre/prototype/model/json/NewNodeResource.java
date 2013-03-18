///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//package org.gre.prototype.model.json;
//
//import com.google.gson.Gson;
//import com.model.pojos.Response;
//import javax.ws.rs.core.Context;
//import javax.ws.rs.core.UriInfo;
//import javax.ws.rs.GET;
//import javax.ws.rs.POST;
//import javax.ws.rs.Path;
//import javax.ws.rs.Produces;
//
///**
// * REST Web Service
// *
// * @author ppadilla
// */
//@Path("newNode")
//public class NewNodeResource {
//
//    @Context
//    private UriInfo context;
//
//    /**
//     * Creates a new instance of NewNodeResource
//     */
//    public NewNodeResource() {
//    }
//
//    /**
//     * Retrieves representation of an instance of com.model.json.NewNodeResource
//     *
//     * @return an instance of java.lang.String
//     */
//    @POST
//    @Produces("application/json")
//    public String getJson() {
//        Response resp = new Response(0, "Success!");
//        Gson gson = new Gson();
//        return gson.toJson(resp);
//    }
//
//}
