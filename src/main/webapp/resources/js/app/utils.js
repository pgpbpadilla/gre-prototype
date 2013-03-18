var serviceNames = {
    FindNodes: 'webresources/findNodes',
    GetNode: 'webresources/getNode',
    NewNode: 'webresources/newNode',
    DeleteNode: 'delete_node',
    UpdateNode: 'update_node'
};

function RequestManager() {

    this.defaultTimeOut = 10000; //10 seconds

    this.callService = function(servicePath, paramsObj, callback) {
        this.callService(servicePath, paramsObj, callback, this.defaultTimeOut);
    };
    this.callService = function(servicePath, paramsObj, callback, timeout) {

        $.ajax({
            type: "POST",
            timeout: timeout,
            url: servicePath,
            data: paramsObj,
            success: function(data) {
                console.log('done');
                callback(data);
            },
            error: function(request, error) {
                console.log(JSON.stringify(request)
                        + "\nERROR:" + JSON.stringify(error));
            }
        });
    };
}