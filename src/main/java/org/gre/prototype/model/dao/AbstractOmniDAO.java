/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gre.prototype.model.dao;


import java.util.List;
import org.gre.prototype.model.pojos.*;

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
