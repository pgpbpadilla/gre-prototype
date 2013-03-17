/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gre.prototype.model.dao;

import com.model.pojos.Node;
import org.apache.commons.collections.Predicate;

/**
 *
 * @author ppadilla
 */
public class TestPredicate implements Predicate {

    String testStr;

    public TestPredicate(String test) {
        testStr = test;
    }

    @Override
    public boolean evaluate(Object o) {
        Node n = (Node) o;
        return (n.getName().contains(testStr)
                || n.getDescription().contains(testStr));
    }
}
