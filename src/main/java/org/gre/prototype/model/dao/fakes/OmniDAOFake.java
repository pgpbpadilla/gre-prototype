/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gre.prototype.model.dao.fakes;

import com.model.pojos.Link;
import com.model.pojos.Node;
import java.util.List;
import org.apache.commons.collections.CollectionUtils;
import org.gre.prototype.model.dao.AbstractOmniDAO;
import org.gre.prototype.utils.NodeContainsPredicate;

/**
 *
 * @author ppadilla
 */
public class OmniDAOFake implements AbstractOmniDAO {

    private DBFake dbFake;

    public OmniDAOFake() {

        dbFake = DBFake.getInstance();
    }

    @Override
    public List<Node> getAllNodes() {
        return dbFake.allNodes;
    }

    @Override
    public List<Node> getRelatedNodes(Node source) {
        return dbFake.allNodes;
    }

    @Override
    public boolean createNewNode(Node n) {

        n.setId(dbFake.allNodes.size());
        dbFake.allNodes.add(n);

        return true;
    }

    @Override
    public boolean addRelationship(Node source, Node target, String relDesc) {

        // check if already exists
        // if not, then create it
        Node srcInstance = dbFake.allNodes.get(dbFake.allNodes.indexOf(source));
        Node tgtInstance = dbFake.allNodes.get(dbFake.allNodes.indexOf(target));

        Link rel = new Link(dbFake.allLinks.size(), relDesc, srcInstance, tgtInstance);

        dbFake.allLinks.add(rel);
        return true;
    }

    @Override
        public boolean deleteNode(Node n) {

        Node toDel = dbFake.allNodes.get(dbFake.allNodes.indexOf(n));
        dbFake.allNodes.remove(toDel);

        return true;
    }

    @Override
        public boolean removeRelationship(Link relationship) {
        return true;
    }

    @Override
        public boolean updateNode(Node n) {
        return true;
    }

    public List<Node> findNodes(String pTest) {

        List<Node> result = (List<Node>) CollectionUtils.select(dbFake.allNodes,
                new NodeContainsPredicate(pTest));

        return result;
    }
}
