/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.pojos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ppadilla
 */
public class Node {
    int id;
    String name;
    String contents;
    /** Tags will allow for faster searches 
     * This way we can index the Nodes by topic
     */
    
    // this will be used to: 
    // - discriminate among types of concepts
    // - areas to which the concepts belong
    List<String> tags;
    List<Presentation> presentations;

    public Node() {
        name="";
        contents="";
        tags=null;
        presentations=null;
    }

    public Node(int id, String name, String description, List<String> tags) {
        this.id = id;
        this.name = name;
        this.contents = description;
    }

    public String getDescription() {
        return contents;
    }

    public void setDescription(String description) {
        this.contents = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<Presentation> getPresentations() {
        return presentations;
    }

    public void setPresentations(List<Presentation> presentations) {
        this.presentations = presentations;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.id;
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
        final Node other = (Node) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    
    
    
}
