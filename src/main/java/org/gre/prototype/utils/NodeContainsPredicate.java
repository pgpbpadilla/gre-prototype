/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gre.prototype.utils;

import org.gre.prototype.model.pojos.Node;
import org.apache.commons.collections.Predicate;

/**
 *
 * @author ppadilla
 */

/**
 * @brief Predicate used to find out if the node contains 
 * the given text in its name or description.
 */
public class NodeContainsPredicate implements Predicate {

    String searchTerm;

    public NodeContainsPredicate(String searchText) {
        this.searchTerm = searchText;
    }

    /**
     * @return true if the node contains the given string 
     * in its name or description
     */
    @Override
    public boolean evaluate(Object o) {
        Node n = (Node) o;
        return (n.getTitle().contains(searchTerm)
                || n.getContent().contains(searchTerm));
    }
}
