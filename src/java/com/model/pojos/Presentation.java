/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.pojos;

/**
 *
 * @author ppadilla
 */
public class Presentation {
    Node concept;
    String textBlob;

    public Presentation() {
    }

    public Presentation(Node concept, String textBlob) {
        this.concept = concept;
        this.textBlob = textBlob;
    }

    public Node getConcept() {
        return concept;
    }

    public void setConcept(Node concept) {
        this.concept = concept;
    }

    public String getTextBlob() {
        return textBlob;
    }

    public void setTextBlob(String textBlob) {
        this.textBlob = textBlob;
    }
    
    
    
}

