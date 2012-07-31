/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.view.controller;

import com.utils.Filter;
import com.model.dao.DummyOmniDAO;
import com.model.pojos.Node;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
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

    /**
     * Creates a new instance of ViewController
     */
    public ViewController() {
        sourceNodes = null;
        relatedNodes = null;
        sourceContent="";
        relatedContent="";

        loadSourceConcepts();
    }

    public DataModel getAllNodes() {
        return sourceNodes;
    }

    public void setAllNodes(DataModel allNodes) {
        this.sourceNodes = allNodes;
    }

    /**
     * Retrieves the basic info for all nodes in the data base: name,
     * description
     */
    private void loadSourceConcepts() {
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
        currentSource = (Node) sourceNodes.getRowData();
        relatedNodes = sourceNodes;
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
    public void showRelated(){
        relatedContent=currentRelated.getPresentations().get(0).getTextBlob();
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
    
    public void loadRelatedContent(){
        relatedContent=currentRelated.getPresentations().get(0).getTextBlob();
    }
    public void loadSourceContent(){
        sourceContent=currentSource.getPresentations().get(0).getTextBlob();
    }
    public void loadSource(){
        currentSource = (Node) sourceNodes.getRowData();
        loadSourceContent();
        loadAllRelated();
    }
    public void loadRelated(){
        currentRelated= (Node) relatedNodes.getRowData();
        loadRelatedContent();
    }
}
