/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.dao;

import com.model.pojos.Node;
import java.util.List;

/**
 *
 * @author ppadilla
 */
public interface AbstractOmniDAO {

    public List<Node> getAllNodes();

    public List<Node> getRelatedNodes(Node source);
}
