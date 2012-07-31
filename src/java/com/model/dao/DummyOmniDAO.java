/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.dao;

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

        for (int i = 0; i < 10; ++i) {
            list.add(new Node(i, "Name " + i, "Description of node " + i +": Adi dui dambala" , null));
        }

        return list;
    }

    @Override
    public List<Node> getRelatedNodes(Node source) {
        List<Node> list = new ArrayList<Node>();

        for (int i = 0; i < 10; ++i) {
            list.add(new Node(i, "Name " + i, "Desc " + i, null));
        }

        return list;
    }
}
