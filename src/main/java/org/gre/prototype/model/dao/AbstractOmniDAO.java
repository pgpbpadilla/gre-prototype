/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gre.prototype.model.dao;

import com.model.pojos.Link;
import com.model.pojos.Node;
import java.util.List;

/**
 *
 * @author ppadilla
 */
public interface AbstractOmniDAO {

    public List<Node> getAllNodes();

    public List<Node> getRelatedNodes(Node source);

    public boolean createNewNode(Node n);

    public boolean deleteNode(Node n);

    public boolean updateNode(Node n);

    public boolean addRelationship(Node source, Node target, String relDesc);

    public boolean removeRelationship(Link relationship);
}
