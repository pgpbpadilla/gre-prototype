/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gre.prototype.controller;

import com.google.gson.Gson;
import org.gre.prototype.model.pojos.Node;
import com.model.pojos.Response;
import java.util.List;
import javax.ws.rs.Produces;
import org.gre.prototype.model.dao.fakes.OmniDAOFake;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author rfierro
 */

@Controller
@RequestMapping("/services/*")
public class ServicesController {
    
    @RequestMapping("find_nodes")
    @Produces("application/json")
    public @ResponseBody Object findNodes(
            @RequestParam(value = "searchText", required = false) String searchText) {
        
        OmniDAOFake dao= new OmniDAOFake();
        
        List<Node> nodes = dao.findNodes(searchText);

        Gson gson = new Gson();
        String json = gson.toJson(nodes);
        System.out.println("JSON: " + json);
        return json;

    }
    
    @RequestMapping("new_node")
    @Produces("application/json")
    public @ResponseBody Object newNode(
            @RequestParam(value = "test", required = false) String psTest) {
        
        Response resp = new Response(0, "Success!");
        Gson gson = new Gson();
        return gson.toJson(resp);

    }
}
