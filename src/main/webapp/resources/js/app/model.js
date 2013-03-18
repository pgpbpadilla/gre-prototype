function Node() {
    this.id;
    this.name;
    this.content;
}

function GRETool() {

    // a reference to the view-controller
    this.delegate = {};

    // create a new node to save the current work
    this.curEditingNode = {};
    this.curEditingNode.prototype = new Node();
    // create the request manager
    rm = new RequestManager();
    // temporal function to process request responses
    function printResponse(data) {
        console.log(JSON.stringify(data));
    }

    // call a RESTful service to create a new node
    this.createNode = function(newNode) {

        var params = {
            content: newNode.content
        };
        rm.callService(serviceNames.NewNode, params, printResponse);
    };
    
    // call a RESTful service to search for nodes
    this.findNodes = function(searchText) {

        var params = {
            searchText: searchText
        };
        
        rm.callService(serviceNames.FindNodes, params, this.delegate.showFoundNodes);
    };
}
