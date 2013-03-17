/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gre.prototype.model.dao;

import com.model.pojos.Link;
import com.model.pojos.Node;
import java.util.List;
import org.apache.commons.collections.CollectionUtils;

/**
 *
 * @author ppadilla
 */
public class DummyOmniDAO implements AbstractOmniDAO {

    private DBFake dbFake;

    public DummyOmniDAO() {

        dbFake = DBFake.getInstance();
    }

    public List<Node> getAllNodes() {
        return dbFake.allNodes;
    }

    public List<Node> getRelatedNodes(Node source) {
        return dbFake.allNodes;
    }

    public boolean createNewNode(Node n) {

        n.setId(dbFake.allNodes.size());
        dbFake.allNodes.add(n);

        return true;
    }

    public boolean addRelationship(Node source, Node target, String relDesc) {

        // check if already exists
        // if not, then create it
        Node srcInstance = dbFake.allNodes.get(dbFake.allNodes.indexOf(source));
        Node tgtInstance = dbFake.allNodes.get(dbFake.allNodes.indexOf(target));

        Link rel = new Link(dbFake.allLinks.size(), relDesc, srcInstance, tgtInstance);

        dbFake.allLinks.add(rel);
        return true;
    }

        public boolean deleteNode(Node n) {

        Node toDel = dbFake.allNodes.get(dbFake.allNodes.indexOf(n));
        dbFake.allLinks.remove(toDel);

        return true;
    }

        public boolean removeRelationship(Link relationship) {
        return true;
    }

        public boolean updateNode(Node n) {
        return true;
    }

    public List<Node> findNodes(String pTest) {

        List<Node> result = (List<Node>) CollectionUtils.select(dbFake.allNodes,
                new TestPredicate(pTest));

        return result;
    }
}
