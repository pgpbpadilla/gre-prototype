var serviceNames = {
    FindNodes: 'webresources/findNodes',
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

function Node() {
    this.id;
    this.name;
    this.content;
}

function GRETool() {

    this.curEditingNode = {};
    this.curEditingNode.prototype = new Node();

    rm = new RequestManager();

    function printResponse(data) {
        console.log(JSON.stringify(data));
    }

    this.createNode = function(newNode) {

        params = {
            content: newNode.content
        };

        rm.callService(serviceNames.NewNode, params, printResponse);
    };


}

var View = {
    processData: function(data) {

        $('.editor').text(JSON.stringify(data));

    },
    loadTest: function() {

        var testParams = {
            test: '1'
        };
        var rm = new RequestManager();

        rm.callService(serviceNames.FindNodes, testParams, this.processData);

    },
    buildMainContainer: function() {

        // create workspace
        var appWorkspace = $('<div>');
        appWorkspace.prop('id', 'workspace');
        appWorkspace.addClass('workspace');

        // main content
        var mainContent = $('<div>');
        mainContent.prop('id', 'main-content');
        mainContent.addClass('main-content');

        // menu bar
        var menuBar = $('<div>');
        menuBar.prop('id', 'menu-bar');
        menuBar.addClass('menu-bar');

        var tagFinder = $('<div>');
        tagFinder.prop('tag-finder');
        tagFinder.addClass('tag-finder');
        tagFinder.append($('<input>'));
        // test input
        tagFinder.find('input').prop('placeholder', 'placeholder');
        tagFinder.find('input').val('text');
        menuBar.append(tagFinder); // append menu bar to workspace

        var optionsMenu = $('<div>');
        optionsMenu.prop('id', 'options-menu');
        optionsMenu.addClass('options-menu');
        optionsMenu.text('Options Menu');
        menuBar.append(optionsMenu);

        var leftBar = $('<div>');
        leftBar.prop('id', 'left-bar');
        leftBar.addClass('left-bar');
        leftBar.append($('<div>').text('CW'));

        var questionBar = $('<div>');
        questionBar.prop('id', 'current-question');
        questionBar.addClass('current-question');
        questionBar.text('Why did the chicken crossed the road..?');
        mainContent.append(questionBar); // append questionBar to mainContent

        var editor = $('<div>');
        editor.prop('id', 'editor');
        editor.addClass('editor');
        editor.text('This will be the editor');
        mainContent.append(editor); // append the editor 

        appWorkspace.append(menuBar);
        appWorkspace.append(leftBar);
        appWorkspace.append(mainContent)

        $('body').append(appWorkspace); // append the workspace to the page

    }

};