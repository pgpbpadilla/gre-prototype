/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.dao;

import com.model.pojos.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ppadilla
 */
public class DBFake {

    private static DBFake dbFake = null;
    public List<Node> allNodes;
    public List<Link> allLinks;

    private DBFake() {
        allNodes = new ArrayList<Node>();

        // TODO: keep only for testing
        for (int i = 0; i < 10; ++i) {
            allNodes.add(new Node(i, "Name " + i, "Description of node "
                    + i + ": Adi dui dambala", null));
        }

    }

    public static DBFake getInstance() {

        if (null == dbFake) {
            dbFake = new DBFake();
        }

        return dbFake;
    }
}
