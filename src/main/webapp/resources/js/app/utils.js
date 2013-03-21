var requestManager = {
    defaultTimeOut: 10000, //10 seconds

    callService: function(servicePath, paramsObj, callback) {
        this.callServiceWithTimeOut(servicePath, paramsObj, callback, this.defaultTimeOut);
    },
    callServiceWithTimeOut: function(servicePath, paramsObj, callback, timeout) {

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
    }
};