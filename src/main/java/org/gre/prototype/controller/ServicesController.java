/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gre.prototype.controller;

import com.google.gson.Gson;
import com.model.pojos.Node;
import com.model.pojos.Response;
import java.util.List;
import javax.ws.rs.Produces;
import org.gre.prototype.model.dao.DummyOmniDAO;
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
    
    @RequestMapping("find_nodes.html")
    @Produces("application/json")
    public @ResponseBody Object findNodes(
            @RequestParam(value = "test", required = false) String psTest) {
        
        DummyOmniDAO dao = new DummyOmniDAO();
        
        List<Node> nodes = dao.findNodes(psTest);

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
