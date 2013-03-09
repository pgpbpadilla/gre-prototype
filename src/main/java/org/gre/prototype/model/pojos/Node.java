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
    String description;
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
        description="";
        tags=null;
        presentations=null;
    }

    public Node(int id, String name, String description, List<String> tags) {
        this.id = id;
        this.name = name;
        this.description = description;
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
    
    
    
}
