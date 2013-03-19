/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gre.prototype.model.dao.fakes;

import java.util.ArrayList;
import java.util.List;
import org.gre.prototype.model.pojos.Link;
import org.gre.prototype.model.pojos.Node;

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
