var requestManager = {
    defaultTimeOut: 10000, //10 seconds

    callService: function(settings) {

        var timeout;
        // use custom timeout if specified
        if (settings.timeout !== undefined) {
            timeout = settings.timeout;
        } else {
            timeout = this.defaultTimeOut;
        }

        $.ajax({
            type: "POST",
            timeout: timeout,
            url: settings.servicePath,
            data: settings.params,
            success: function(data) {
                console.log('done');
                // delegate is model
                // calls model.callback
                settings.callback.apply(settings.delegate, [JSON.parse(data)]);
            },
            error: function(request, error) {
                console.log(JSON.stringify(request)
                        + "\nERROR:" + JSON.stringify(error));
            }
        });
    }
};