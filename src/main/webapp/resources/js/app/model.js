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
    createNode: function(newNode) {},
    // call a RESTful service to search for nodes containing
    // searchText in its name or content
    findNodes: function(searchText) {

        var params = {
            searchText: searchText
        };

        this.rm.callService({
            servicePath: this.services.FindNodes,
            params: params,
            delegate: this,
            callback: this.processFoundNodes
        });
    },
    setCurrentNode: function(node) {

        this.curEditingNode = node;
        // tell the controller to process the current node
        this.delegate.setCurNode(this.curEditingNode);
        // ask the view controller to close the results view
        this.delegate.closeResults();
    },
    getNode: function(nodeId) {
    },
    // callback for FindNodes call
    processFoundNodes: function(nodes) {

        this.delegate.showFoundNodes(nodes);
    }
};
