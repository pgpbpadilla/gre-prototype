/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.dao;

import com.model.pojos.Link;
import com.model.pojos.Node;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ppadilla
 */
public class DummyOmniDAO implements AbstractOmniDAO {

    @Override
    public List<Node> getAllNodes() {
        List<Node> list = new ArrayList<Node>();

        for (int i = 0; i < 30; ++i) {
            list.add(new Node(i, "Name " + i, "Description of node " + i + ": Adi dui dambala", null));
        }

        return list;
    }

    @Override
    public List<Node> getRelatedNodes(Node source) {
        List<Node> list = new ArrayList<Node>();

        for (int i = 0; i < 10; ++i) {
            list.add(new Node(i, "Related: Name " + i, "Desc " + i, null));
        }

        return list;
    }

    @Override
    public boolean createNewNode(Node n) {
        return true;
    }

    @Override
    public boolean addRelationship(Node source, Node target) {
        return true;
    }

    @Override
    public boolean deleteNode(Node n) {
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
}
