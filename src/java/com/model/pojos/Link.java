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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + this.id;
        hash = 47 * hash + (this.source != null ? this.source.hashCode() : 0);
        hash = 47 * hash + (this.target != null ? this.target.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Link other = (Link) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.source != other.source && (this.source == null || !this.source.equals(other.source))) {
            return false;
        }
        if (this.target != other.target && (this.target == null || !this.target.equals(other.target))) {
            return false;
        }
        return true;
    }
    
    
    
}
