/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.view.controller;

import com.model.dao.DummyOmniDAO;
import com.model.pojos.Node;
import java.util.List;
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

    DataModel allNodes;

    /**
     * Creates a new instance of ViewController
     */
    public ViewController() {
        DummyOmniDAO dod = new DummyOmniDAO();

        allNodes = new ListDataModel<Node>(dod.getAllNodes());
    }

    public DataModel getAllNodes() {
        return allNodes;
    }

    public void setAllNodes(DataModel allNodes) {
        this.allNodes = allNodes;
    }
    
    
}
