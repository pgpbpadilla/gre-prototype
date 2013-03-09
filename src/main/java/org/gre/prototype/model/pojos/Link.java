/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.pojos;

/**
 *
 * @author ppadilla
 */
public class Link {
    int id;
    String description;
    Node source;
    Node target;

    public Link() {
    }

    public Link(int id, String description, Node source, Node target) {
        this.id = id;
        this.description = description;
        this.source = source;
        this.target = target;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Node getSource() {
        return source;
    }

    public void setSource(Node source) {
        this.source = source;
    }

    public Node getTarget() {
        return target;
    }

    public void setTarget(Node target) {
        this.target = target;
    }
    
    
    
}
