var node = {
    id: '',
    name: '',
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
    // create a new node to save the current work
    curEditingNode: Object.create(node),
    // create the request manager
    rm: Object.create(requestManager),
    // call a RESTful service to create a new node
    createNode: function(newNode) {

        var params = {
            content: newNode.content
        };
        this.rm.callService(serviceNames.NewNode, params, printResponse);
    },
    // call a RESTful service to search for nodes
    findNodes: function(searchText) {

        var params = {
            searchText: searchText
        };
        this.rm.callService(this.services.FindNodes, params, this.delegate.showFoundNodes);
    },
    setCurrentNode: function(node) {

        this.curEditingNode = node;
        // ask the view controller to close the results view
        this.delegate.closeResults();
    },
    getNode: function(nodeId) {

        var params = {
            nodeId: nodeId
        };
        this.rm.callService(this.services.GetNode, params, this.setCurrentNode);
    }
};
