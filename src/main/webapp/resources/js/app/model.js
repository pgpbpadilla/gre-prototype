var node = {
    id: '',
    title: '',
    content: ''
};

var greTool = {
    services: {
        FindNodes: 'gre/services/find_nodes',
        GetNode: 'gre/services/get_node',
        NewNode: 'gre/services/new_node',
        DeleteNode: 'gre/services/delete_node',
        UpdateNode: 'gre/services/update_node'
    },
    // a reference to the view-controller
    delegate: null,
    // reference to a request manager, used to invoke RESTful JSON services
    rm: Object.create(requestManager),
    // getters & setters
    setCurrentConcept: function(conceptNode) {

        // if the concept is null, show an error message and return
        if (conceptNode === null) {
            var message = 'Cannot assign null to current concept. \n'
                    + 'There\'s nothing to show';
            console.log(message);
            if (this.delegate !== null) {
                this.delegate.showMessage(message);
            }
            return;
        }

        // assign the new value to our static property
        greTool.currentConcept = conceptNode;
    },
    getCurrentConcept: function() {
        return greTool.currentConcept;
    },
    setCurrentQuestion: function(questionNode) {

        // if the node is null, show an error message and return
        if (questionNode === null) {
            var message = 'Cannot assign null to current question. \n'
                    + 'There\'s nothing to show';
            console.log(message);
            if (this.delegate !== null) {
                this.delegate.showMessage(message);
            }
            return;
        }

        // assign the new value to our static property
        greTool.currentConcept = questionNode;

        // use the delegate to show the current question
        if (this.delegate !== null) {
            this.delegate.showCurrentQuestion(greTool.currentQuestion);
        }
    },
    getCurrentQuestion: function() {
        return greTool.currentQuestion;
    },
    setCurrentRelatedConcept: function(conceptNode) {

        // if the concept is null, show an error message and return
        if (conceptNode === null) {
            var message = 'Cannot assign null to current question. \n'
                    + 'There\'s nothing to show';
            console.log(message);
            if (this.delegate !== null) {
                this.delegate.showMessage(message);
            }
            return;
        }

        // assign the new value to our static property
        greTool.currentRelatedConcept = conceptNode;

        // use the delegate to show the current concept
        if (this.delegate !== null) {
            this.delegate.showRelatedConcept(greTool.currentRelatedConcept);
        }
    },
    getCurrentRelatedConcept: function() {
        return greTool.currentRelatedConcept;
    },
    // calls a RESTful service to create a new node
    createNode: function(title, content) {

        this.rm.createNode({
            servicePath: this.services.NewNode,
            params: {
                title: title,
                content: content
            },
            delegate: this,
            callback: this.processResponse
        });
    },
    findNodes: function(searchText) {

        this.rm.callService({
            servicePath: this.services.FindNodes,
            params: {
                searchText: searchText
            },
            delegate: this,
            callback: this.processFoundNodes
        });
    },
    deleteNode: function(nodeId) {

        this.rm.callService({
            servicePath: this.services.DeleteNode,
            params: {
                node_id: nodeId
            },
            delegate: this,
            callback: this.processResponse
        });
    },
    updateNode: function(node) {
        this.rm.callService({
            servicePath: this.services.UpdateNode,
            params: {
                title: node.title,
                content: node.content
            },
            delegate: this,
            callback: this.processResponse()
        });
    },
    // Callback functions to process data on succesful return of the ajax call

    // generic functions to process the response of services
    // from which only true/false is expected
    processResponse: function(response) {
        console.log(JSON.stringify(response));
        if (this.delegate !== null) {
            this.delegate.showResponse(response);
        }
    },
    // callback for FindNodes call
    processFoundNodes: function(nodes) {
        console.log(JSON.stringify(nodes));

        // if the delegate is assigned, use it to display the results
        if (this.delegate !== null) {
            this.delegate.showFoundNodes(nodes);
        }
    },
    // methods to change the state from the view controller
    selectConceptFromResult: function(node) {

        this.setCurrentConcept(node);

        if (this.delegate !== null) {
            this.delegate.closeResults();
            // use the delegate to show the current concept
            this.delegate.showCurrentConcept(greTool.currentConcept);
        }
    }

};

// static vars
// reference to the current concept
greTool.currentConcept = null;
// reference to the current question
greTool.currentQuestion = null;
// reference to the current related concept
greTool.currentRelatedConcept = null;
// list of related nodes
greTool.relatedNodes = [];

