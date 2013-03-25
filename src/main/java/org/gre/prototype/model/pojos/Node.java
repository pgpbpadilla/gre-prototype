/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gre.prototype.model.pojos;

import java.util.List;

/**
 *
 * @author ppadilla
 */
public class Node {
    int id;
    String title;
    String content;
    /** Tags will allow for faster searches 
     * This way we can index the Nodes by topic
     */
    
    // this will be used to: 
    // - discriminate among types of concepts
    // - areas to which the concepts belong
    List<String> tags;
    List<Presentation> presentations;

    public Node() {
        title="";
        content="";
        tags=null;
        presentations=null;
    }

    public Node(int id, String name, String description, List<String> tags) {
        this.id = id;
        this.title = name;
        this.content = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
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
