/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gre.prototype.view.controller;

import com.model.dao.AbstractOmniDAO;
import com.utils.Filter;
import com.model.dao.DummyOmniDAO;
import com.model.pojos.Node;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author ppadilla
 */
@ManagedBean
@SessionScoped
public class ViewController {

    DataModel sourceNodes;
    DataModel relatedNodes;
    Node currentSource;
    Node currentRelated;
    String sourceContent;
    String relatedContent;
    
    Node newNode;

    
    /**
     * Creates a new instance of ViewController
     */
    public ViewController() {
        
        newNode= new Node();
        sourceNodes = null;
        relatedNodes = null;
        sourceContent = "";
        relatedContent = "";


        // load all the source nodes
        loadSourceNodes();
    }

    /**
     * Retrieves the basic info for all nodes in the data base: name,
     * description
     */
    private void loadSourceNodes() {
        DummyOmniDAO dod = new DummyOmniDAO();
        sourceNodes = new ListDataModel<Node>(dod.getAllNodes());
    }

    /**
     * Retrieves all related nodes for node source
     *
     * @param source {String} The source node for which all relationships will
     * be retrieved
     * @return DataModel
     */
    public void loadAllRelated() {
        AbstractOmniDAO dao = new DummyOmniDAO();
        currentSource = (Node) sourceNodes.getRowData();
        relatedNodes = new ListDataModel<Node>(dao.getRelatedNodes(currentSource));
    }

    /**
     * Retrieves all related nodes that match the given filter
     *
     */
    private DataModel getRelatedWithFilter(Node source, Filter filter) {
        DataModel related = new ListDataModel<Node>();

        related = sourceNodes;
        return related;
    }

    public DataModel getSourceNodes() {
        return sourceNodes;
    }

    public void setSourceNodes(DataModel sourceNodes) {
        this.sourceNodes = sourceNodes;
    }

    public DataModel getRelatedNodes() {
        return relatedNodes;
    }

    public void setRelatedNodes(DataModel relatedNodes) {
        this.relatedNodes = relatedNodes;
    }

    public Node getCurrentSource() {
        return currentSource;
    }

    public void setCurrentSource(Node currentSource) {
        this.currentSource = currentSource;
    }

    public void showRelated() {
        relatedContent = currentRelated.getPresentations().get(0).getTextBlob();
    }

    public Node getCurrentRelated() {
        return currentRelated;
    }

    public void setCurrentRelated(Node currentRelated) {
        this.currentRelated = currentRelated;
    }

    public String getSourceContent() {
        return sourceContent;
    }

    public void setSourceContent(String sourceContent) {
        this.sourceContent = sourceContent;
    }

    public String getRelatedContent() {
        return relatedContent;
    }

    public void setRelatedContent(String relatedContent) {
        this.relatedContent = relatedContent;
    }

    public void loadRelatedContent() {
        relatedContent = currentRelated.getPresentations().get(0).getTextBlob();
    }

    public void loadSourceContent() {
        sourceContent = currentSource.getPresentations().get(0).getTextBlob();
    }

    public void loadSource() {
        currentSource = (Node) sourceNodes.getRowData();
        loadSourceContent();
        loadAllRelated();
    }

    public void loadRelated() {
        currentRelated = (Node) relatedNodes.getRowData();
        loadRelatedContent();
    }

    public void createNode() {
        AbstractOmniDAO dao = new DummyOmniDAO();
        String message = "";

        if (dao.createNewNode(newNode)) {
            // show message of success
            message = "Sucess!";

        } else {
            message = "ERROR createing new node.";
        }
        FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, message, null);
        FacesContext.getCurrentInstance().addMessage(null, fm);
    }

    public Node getNewNode() {
        return newNode;
    }

    public void setNewNode(Node newNode) {
        this.newNode = newNode;
    }
    
    
}
